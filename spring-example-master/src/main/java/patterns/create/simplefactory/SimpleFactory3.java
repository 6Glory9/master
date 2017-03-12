/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2016-03-31 13:51 创建
 *
 */
package patterns.create.simplefactory;

/**
 * @author jxilong@yiji.com
 */
public class SimpleFactory3 {
	
	public static Sender createEmailSender() {
		return new EmailSender();
	}
	
	public static Sender createMobileSender() {
		return new MobileSender();
	}
}
