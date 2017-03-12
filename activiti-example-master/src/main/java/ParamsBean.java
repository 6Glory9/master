/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-12 19:21 创建
 *
 */

import com.yjf.common.util.ToString;

import java.io.Serializable;

/**
 * @author jxilong@yiji.com
 */
public class ParamsBean implements Serializable {
	
	private static final long serialVersionUID = -3260827121660251543L;
	private String userName;
	
	private int age;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return ToString.toString(this);
	}
}
