package icu.aierx.po;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 等待方法执行完成之后，通知搜索引擎更新数据
 *
 * @author leiwenyong
 * @since 2022-08-25
 */
@Target({TYPE, FIELD, METHOD})
@Retention(RUNTIME)
public @interface NotifyES {
	
	/**
	 * <P>表达式遵循mybatis参数解析规则</P>
	 * <P>如果需要获取第一个参数是字符串类型请使用表达 [0]</P>
	 * <P>如果需要获取第二个参数是对象请按照如下方式获取属性:</P>
	 * <P>普通字段：[1].decisionId</P>
	 * <P>普通对象：[1].decisionPoint.decisionPointId</P>
	 * <P>列表字段：[1].listDecisionLevel[0].decisionLevelId</P>
	 * @return 需要更新的业务Id
	 */
	String value() default "";
	
	/**
	 * 添加简单的描述
	 *
	 * @return 描述
	 */
	String desc() default "";
	
	/**
	 * 需要修改的模型数据
	 *
	 * @return 模型数据
	 */
	String name() default "";
	
}
