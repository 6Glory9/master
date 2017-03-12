/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2016-03-25 09:47 创建
 *
 */
package ioc.beans.annotations;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author jxilong@yiji.com
 */
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER,TYPE })
@Retention(RUNTIME)
@Documented
@Service("father service")
@Inherited
@Component("father")
@AnnotationA(a="son",b = "son")
public @interface AnnotationParent {
}
