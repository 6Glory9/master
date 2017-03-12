/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-09-19 15:20 创建
 *
 */
package util;

import bean.UserInfo;

import java.util.Date;

/**
 * @author jxilong@yiji.com
 */
public class UserInfoTransformationProcessor extends TransformationProcessor<UserInfo, UserInfo> {
	
	@Override
	protected UserInfo transformation(UserInfo userInfo) {
		userInfo.setRawAddTime(new Date());
		return userInfo;
	}
}
