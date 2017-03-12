/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-09-19 09:29 创建
 *
 */
package bean;

import com.yjf.common.lang.enums.GenderEnum;
import com.yjf.common.util.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jxilong@yiji.com
 */
public class UserInfo implements Serializable {
	
	/* 姓名*/
	@Length(min = 1, max = 5)
	private String userName;
	
	/* 年龄*/
	@Max(28)
	@Min(1)
	private int age = 1;
	
	private GenderEnum sex;
	
	private Date rawAddTime;
	
	public Date getRawAddTime() {
		return rawAddTime;
	}
	
	public void setRawAddTime(Date rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
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
	
	public GenderEnum getSex() {
		return sex;
	}
	
	public void setSex(GenderEnum sex) {
		this.sex = sex;
	}
	
	@Override
	public String toString() {
		return ToString.toString(this);
	}
}
