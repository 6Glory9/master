/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-07-19 06:49 创建
 *
 */
package form;

import com.yjf.common.util.ToString;
import form.validator.Gid;
import form.validator.Group;
import form.validator.Group2;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;

/**
 * @author jxilong@yiji.com
 */
public class UserValidateBean implements Serializable {
	
	@NotBlank(groups = Group.class, message = "{UserValidateBean.userName}")
	private String userName;


	@Gid(groups = Group.class)
	private String gid;
	
	@DecimalMin("1")
	@DecimalMax("10000")
	private long sale;
	
	@Email(groups = Group2.class, message = "{UserValidateBean.email}")
	private String email;

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public long getSale() {
		return sale;
	}
	
	public void setSale(long sale) {
		this.sale = sale;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return ToString.toString(this);
	}
}
