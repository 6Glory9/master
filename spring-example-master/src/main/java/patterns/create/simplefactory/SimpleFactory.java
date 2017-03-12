/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2016-03-31 13:47 创建
 *
 */
package patterns.create.simplefactory;

import org.apache.shiro.util.ClassUtils;

/**
 * @author jxilong@yiji.com
 * 三种工厂方法
 * 1.类型直接由外部传，但外部传错就创建不起
 * 2.根据不同的方法，创建不同类型模型
 * 3.静态的方式，不再创建工厂类，建议这种方式
 *
 */
public class SimpleFactory {
	
	public <T extends Sender> T create(Class<T> senderClass) throws IllegalAccessException, InstantiationException {
		return (T) ClassUtils.forName(senderClass.getName()).newInstance();
	}
}
