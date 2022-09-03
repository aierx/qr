package icu.aierx.po;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * 将该代理方法的顺序设置为0，
 * 表示最开始执行，这样可以保证大多数情况下能在事务提交之后通知ES
 *
 * @author leiwenyong
 * @since 2022-08-25
 */
@Aspect
@Component
@Slf4j
@Order(0)
public class AspectIn {
	
	private final Configuration configuration = new Configuration();
	
	/**
	 * <p>此处使用环绕代理为了获取传入时的参数，因为使用After获取到参数可能会被业务代码修改</p>
	 * <p>是否有其他方法拿到参数？</p>
	 *
	 * @param joinPoint spring提供的代理方法的一些属性
	 * @return 业务代码返回值
	 */
	@Around(value = "icu.aierx.po.AspectIn.pointCut()")
	@SneakyThrows
	public Object app(ProceedingJoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		//1.获取目标方法上的目标注解
		NotifyES annotation = AnnotationUtils.findAnnotation(signature.getMethod(), NotifyES.class);
		// 2.获取要更新数据的唯一ID，提前获取需要通知的数据Id，防止后续代码执行过程中修改该数据
		MetaObject metaObject = configuration.newMetaObject(args);
		Object param = metaObject.getValue(annotation.value());
		Object obj = joinPoint.proceed(args);
		try {
			// 3.等待方法执行完成之后执行通知搜索引擎逻辑
			if ( param instanceof String){
				String thisParam = (String) param;
				// 4.判断当前是不是在事务之中
				boolean inTransaction = TransactionSynchronizationManager.isActualTransactionActive();
				if (inTransaction){
					//  5.1.如果在事务之中，等事务提交再通知搜索引擎更新数据
					TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
						@Override
						public void afterCommit() {
							log.debug("当前事务已经提交");
							// 5.2.执行通知搜索引擎方法
							log.debug(annotation.name()+thisParam);
						}
					});
				}else {
					// 6.如果过没有在事务之中，直接通知搜索引擎更新数据
					log.debug("当前已经没有执行的方法没有事务或者事务已经提交");
					log.debug(annotation.name()+thisParam);
				}
			}
		}catch (Throwable throwable){
			log.error("此处可以设计成出现异常的补救措施，如写入redis，使用定时任务再次通知ES更新数据");
		}
		return obj;
	}
	
	@Pointcut(value = "@annotation(icu.aierx.po.NotifyES)")
	public void pointCut(){
	
	}


}
