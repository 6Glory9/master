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
import org.springframework.batch.item.ItemProcessor;

import java.util.Date;

/**
 * @author jxilong@yiji.com
 */
public class UserInfoFilterProcessor extends TransformationProcessor<UserInfo, UserInfo>
																						implements
																						ItemProcessor<UserInfo, UserInfo> {
	
	@Override
	protected UserInfo transformation(UserInfo userInfo) {
		userInfo.setRawAddTime(new Date());
		if (userInfo.getUserName().equals("liuqing")) {
			return null;
		}
		return userInfo;
	}
	
	@Override
	public UserInfo process(UserInfo item) throws Exception {
		return transformation(item);
	}
}
