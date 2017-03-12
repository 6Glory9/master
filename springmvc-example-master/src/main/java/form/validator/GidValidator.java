/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package form.validator;

import com.yjf.common.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 
 * 全局订单号校验器。
 * 
 * @author jxlong, cyzhang
 *
 */
public class GidValidator implements ConstraintValidator<Gid, String> {

    @Override
    public void initialize(Gid constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(value)) {
            return Boolean.FALSE;
        }
        int valueLength = value.length();
        return valueLength == 35;
    }
}
