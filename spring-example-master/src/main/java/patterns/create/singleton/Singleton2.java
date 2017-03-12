/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2016-03-31 14:26 创建
 *
 */
package patterns.create.singleton;

/**
 * @author jxilong@yiji.com
 */
public class Singleton2 {
	
	private static Singleton2 singleton;
	
	private Singleton2() {
		
	}
	
	public static Singleton2 getInstance() {
		if (singleton == null) {
			synchronized (Singleton2.class) {
				if (singleton == null) {
					singleton = new Singleton2();
				}
			}
		}
		return singleton;
	}
	
}
