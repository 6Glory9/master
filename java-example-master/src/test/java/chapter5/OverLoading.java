/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2016-02-04 20:06 创建
 *
 */
package chapter5;

import org.junit.Test;

import chapter.TestBase;

/**
 *
 *
 * 重载只要参数不同，与返回参数无关
 * 1.顺序 2.个数 3.类型
 * @author jxilong@yiji.com
 */
public class OverLoading extends TestBase {
	
	public static void test(int i, String s) {
		logger.info("param i[{}],s[{}]",i,s);
	}
	
	public static void test(String s, int i) {
		logger.info("param s[{}],i[{}]",s,i);
	}

	public static void test(Object a,Object b) {
		logger.info("param a[{}],b[{}]",a,b);
	}
	
	@Test
	public void clientTest() {
		test(1, "s");
		test("s", 1);
		test("s", "s"); //没找到合适，参数会向上转
	}
}
