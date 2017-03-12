/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-05-31 11:02 创建
 *
 */
package start;

import com.yjf.common.env.Env;
import com.yjf.common.test.TomcatBootstrapHelper;

/**
 * @author jxilong@yiji.com
 */
public class TomcatStart {

	private static int PORT = 8080;
	
	public static void main(String[] args) {
		new TomcatBootstrapHelper(PORT, false, Env.local.name()).start();
	}
}
