/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2016-03-25 09:33 创建
 *
 */
package ioc.reflects;

import base.BaseTest;
import com.yjf.common.lang.validator.MoneyConstraint;
import com.yjf.common.util.ToString;
import ioc.beans.annotations.AnnotationSon;
import org.junit.Test;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import java.lang.annotation.Documented;
import java.util.Set;

/**
 * @author jxilong@yiji.com
 */
@AnnotationSon
public class AnnotationMetadataTest extends BaseTest{
	
	@MoneyConstraint
	private void testMethod() {
		
	}
	
	@Test
	public void testAnnotationMetadataMethod() {
		AnnotationMetadata annotationMetadata = new StandardAnnotationMetadata(getClass());

		Set<MethodMetadata> methodMetadatas = annotationMetadata.getAnnotatedMethods(MoneyConstraint.class.getName());
		Set<MethodMetadata> methodMetadatas2 = annotationMetadata.getAnnotatedMethods(Constraint.class.getName());
		Set<MethodMetadata> methodMetadatas3 = annotationMetadata.getAnnotatedMethods(Documented.class.getName());
        //current
        logger.info(ToString.toString(methodMetadatas));

        //meta
        logger.info(ToString.toString(methodMetadatas2));

        //java Annotation  无法取到
        logger.info(ToString.toString(methodMetadatas3));
	}

    /**
     * AnnotatedTypeMetadata
     *
     * (current,Inherited)annotation and meta
         * isAnnotation
         * getAnnotation
         * getAllAnnotations
     *
     * AnnotationMetadata
     *  annotation
     *
     *
     *  meta
     *
     *
     *  method(annotation or meta)
     *
     *
     */

    @Test
	public void testAnnotationMetadata() {
		AnnotationMetadata annotationMetadata = new StandardAnnotationMetadata(getClass());

        //current annotation and parent of InheritedAnnotation
        logger.info(annotationMetadata.getAnnotationTypes().toString());


        //logger.info(String.valueOf(annotationMetadata.hasMetaAnnotation(Service.class.getName())));

        logger.info(String.valueOf(annotationMetadata.getAllAnnotationAttributes(Component.class.getName()).values().size()));
	}
}
