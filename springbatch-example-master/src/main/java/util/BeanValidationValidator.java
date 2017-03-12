/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-01-22 14:44 创建
 *
 */
package util;

/**
 * @author jxilong@yiji.com
 */

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class BeanValidationValidator<T> implements Validator<T> {
	
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	private javax.validation.Validator validator = factory.getValidator();
	
	public void validate(T value) throws ValidationException {
		
		Set<ConstraintViolation<T>> violations = validator.validate(value);
		
		if (!violations.isEmpty()) {
			throw new ValidationException("Validation failed for " + value + ": " + violations);
		}
	}
	
}
