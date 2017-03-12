/**
 * www.yiji.com Inc.
 * Copyright (c) 2011 All Rights Reserved.
 */
package form.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 *
 * 全局订单号校验注解。
 * 
 * @author jxlong
 *
 */
@Constraint(validatedBy = { GidValidator.class })
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Gid {

    String message() default "全局订单号,不能为空且只能35位";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
