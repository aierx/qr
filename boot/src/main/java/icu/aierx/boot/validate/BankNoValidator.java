package icu.aierx.boot.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author leiwenyong
 * @since 2022-08-05
 */
public class BankNoValidator implements ConstraintValidator<NAN, String> {
	
	
	@Override
	public void initialize(NAN constraintAnnotation) {
		ConstraintValidator.super.initialize(constraintAnnotation);
	}
	
	@Override
	public boolean isValid(String bankNo, ConstraintValidatorContext constraintValidatorContext) {
		return null !=bankNo && !"".equals(bankNo);
	}
}