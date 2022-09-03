package icu.aierx.po.config;

import org.apache.cxf.validation.BeanValidationProvider;
import org.apache.cxf.validation.ValidationConfiguration;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @author leiwenyong
 * @since 2022-08-07
 */
@Configuration
public class ValidateConfig {
	
	@Bean("validatorFactory")
	BeanValidationProvider CreateBeanValidationProvider(){
		ValidationConfiguration validationConfiguration = new ValidationConfiguration();
		HashMap<String, String> map = new HashMap<>(1);
		map.put(HibernateValidatorConfiguration.FAIL_FAST,"true");
		validationConfiguration.setProperties(map);
		BeanValidationProvider beanValidationProvider = new BeanValidationProvider(validationConfiguration);
		return beanValidationProvider;
	}
}
