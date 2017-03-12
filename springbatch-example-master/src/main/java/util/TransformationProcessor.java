/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-09-19 15:18 创建
 *
 */
package util;

/**
 * @author jxilong@yiji.com
 */
public abstract class TransformationProcessor<I, O> {
	
	 protected  abstract O transformation(I i);
	
}
