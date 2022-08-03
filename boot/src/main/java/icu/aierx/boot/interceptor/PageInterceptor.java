package icu.aierx.boot.interceptor;

import icu.aierx.boot.model.AtxPage;
import icu.aierx.boot.model.PageVO;
import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author leiwenyong
 * @since 2022-08-03
 */
@Intercepts(@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))
@Component
public class PageInterceptor implements Interceptor {
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		MappedStatement ms = (MappedStatement) args[0];
		PageVO pageVO = getPageVO(invocation);
		if (isAtxPageQuery(ms, pageVO)) {
			Object parameter = args[1];
			RowBounds rowBounds = (RowBounds) args[2];
			ResultHandler resultHandler = (ResultHandler) args[3];
			Executor executor = (Executor) invocation.getTarget();
			BoundSql boundSql = ms.getBoundSql(parameter);
			CacheKey cacheKey = executor.createCacheKey(ms, parameter, rowBounds, boundSql);
			MappedStatement countMs = builderCountStatement(ms);
			// 创建缓存key
			CacheKey countKey = executor.createCacheKey(countMs, parameter, RowBounds.DEFAULT, boundSql);
			String countSql = getCountSql(boundSql.getSql());
			// 查询数量
			BoundSql countBoundSql = new BoundSql(countMs.getConfiguration(), countSql, boundSql.getParameterMappings(), parameter);
			Object object = executor.query(countMs, parameter, rowBounds, resultHandler, countKey, countBoundSql);
			pageVO.setTotalSize(((Number) ((List) object).get(0)).longValue());
			// 查询结果
			String pageSql = getPageSql(boundSql.getSql(), pageVO);
			BoundSql pageBoundSql = new BoundSql(ms.getConfiguration(), pageSql, boundSql.getParameterMappings(), parameter);
			return executor.query(ms, parameter, RowBounds.DEFAULT, resultHandler, cacheKey, pageBoundSql);
		} else {
			return invocation.proceed();
		}
	}
	
	private boolean isAtxPageQuery(MappedStatement ms, PageVO pageVO) throws ClassNotFoundException {
		boolean flag = false;
		Class<?> clazz = Class.forName(ms.getId().substring(0, ms.getId().lastIndexOf(".")));
		String methodName = ms.getId().substring(ms.getId().lastIndexOf(".") + 1);
		for (Method method : clazz.getDeclaredMethods()) {
			if (method.isAnnotationPresent(AtxPage.class) && method.getName().equals(methodName) && pageVO != null) {
				flag = true;
				break;
			}
		}
		return flag;
	}
	
	private PageVO getPageVO(Invocation invocation) {
		PageVO pageVO = null;
		for (Object arg : invocation.getArgs()) {
			if (arg instanceof PageVO) {
				pageVO = (PageVO) arg;
			}
		}
		return pageVO;
	}
	
	private MappedStatement builderCountStatement(MappedStatement ms) {
		//@todo 可以在这里做个缓存，不用每次都构造
		String newMsId = ms.getId() + "_COUNT";
		MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), newMsId, ms.getSqlSource(), ms.getSqlCommandType());
		builder.resource(ms.getResource());
		builder.fetchSize(ms.getFetchSize());
		builder.statementType(ms.getStatementType());
		builder.keyGenerator(ms.getKeyGenerator());
		builder.timeout(ms.getTimeout());
		builder.parameterMap(ms.getParameterMap());
		builder.cache(ms.getCache());
		builder.resultSetType(ms.getResultSetType());
		builder.flushCacheRequired(ms.isFlushCacheRequired());
		builder.useCache(ms.isUseCache());
		// 构造返回结果集
		List<ResultMap> resultMaps = new ArrayList<ResultMap>();
		ResultMap resultMap = new ResultMap.Builder(ms.getConfiguration(), ms.getId(), Long.class, new ArrayList<>(0)).build();
		resultMaps.add(resultMap);
		builder.resultMaps(resultMaps);
		return builder.build();
	}
	
	public String getPageSql(String sql, PageVO page) {
		StringBuilder sqlStr = new StringBuilder();
		sqlStr.append(sql);
		if (page.getCurPage() == 1) {
			sqlStr.append(" LIMIT ").append(page.getPageSize());
		} else {
			sqlStr.append(" LIMIT ").append((page.getCurPage() - 1) * page.getPageSize()).append(",").append(page.getPageSize());
		}
		return sqlStr.toString();
	}
	
	public String getCountSql(String sql) {
		//构造查询sql
		String header = sql.substring(sql.indexOf("select"), sql.indexOf("select") + 7);
		String tail = sql.substring(sql.indexOf("from") - 1);
		return header + "count(0)" + tail;
	}
	
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}
}
