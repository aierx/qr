package com.aierx.boot;

import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageContentsList;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.service.invoker.MethodDispatcher;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.ClassUtils;
import org.springframework.validation.annotation.Validated;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author leiwenyong
 * @since 2022-09-01
 */
public class BeanValidationInInterceptor extends AbstractPhaseInterceptor {
	Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	
	public BeanValidationInInterceptor() {
		super(Phase.PRE_INVOKE);
	}
	
	@Override
	public void handleMessage(Message message) throws Fault {
		// 拿方法名
		Method method = getServiceMethod(message);
		// 拿参数
		final List<Object> arguments = MessageContentsList.getContentsList(message);
		// 调用校验方法
		Set<ConstraintViolation<Object>> violations = new HashSet<>();
		if (!arguments.isEmpty()) {
			Annotation[][] annotations = method.getParameterAnnotations();
			for (int i = 0; i < arguments.size(); i++) {
				for (Annotation ann : annotations[i]) {
					Validated validatedAnn = AnnotationUtils.getAnnotation(ann, Validated.class);
					if (validatedAnn != null || ann.annotationType().getSimpleName().startsWith("Valid")) {
						Class[] groups = (Class[]) AnnotationUtils.getValue(ann);
						List<Class<?>> strings = Arrays.asList(groups);
						if (strings != null) {
							Set<ConstraintViolation<Object>> validate = validator.validate(arguments.get(i), ClassUtils.toClassArray(strings));
							violations.addAll(validate);
						} else {
							Set<ConstraintViolation<Object>> validate = validator.validate(arguments.get(i));
							violations.addAll(validate);
						}
						break;
					}
				}
			}
			
		}
		// 抛出异常
		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(violations);
		}
	}
	
	protected Method getServiceMethod(Message message) {
		Message inMessage = message.getExchange().getInMessage();
		Method method = null;
		if (inMessage != null) {
			method = (Method) inMessage.get("org.apache.cxf.resource.method");
			if (method == null) {
				BindingOperationInfo bop = inMessage.getExchange().getBindingOperationInfo();
				if (bop != null) {
					MethodDispatcher md = (MethodDispatcher)
							inMessage.getExchange().getService().get(MethodDispatcher.class.getName());
					method = md.getMethod(bop);
				}
			}
		}
		if (method == null) {
			method = message.getExchange().get(Method.class);
		}
		return method;
	}
}
