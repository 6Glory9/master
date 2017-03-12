/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-07-19 06:13 创建
 *
 */
package form;

import com.yjf.common.util.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jxilong@yiji.com
 */
public class UserConvertBean implements Serializable {
	
	private String userName;
	
	private Date birthday;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date born;
	
	@NumberFormat(pattern = "#,###.##")
	private float sale;
	
	@Override
	public String toString() {
		return ToString.toString(this);
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public Date getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	public Date getBorn() {
		return born;
	}
	
	public void setBorn(Date born) {
		this.born = born;
	}
	
	public float getSale() {
		return sale;
	}
	
	public void setSale(float sale) {
		this.sale = sale;
	}
}
