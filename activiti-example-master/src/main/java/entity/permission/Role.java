/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-05 12:34 创建
 *
 */
package entity.permission;

import com.yjf.common.util.ToString;

import java.io.Serializable;
import java.util.Set;

/**
 * @author jxilong@yiji.com
 */
public class Role implements Serializable {
	
	private static final long serialVersionUID = -4004642992528698653L;
	
	private Long id;
	
	private String roleName;
	
	private Role parent;
	
	private Set<Role> childs;
	
	private Set<Permission> permissions;
	
	private String rawAddTime;
	
	private String rawUpdateTime;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRoleName() {
		return roleName;
	}
	
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	public Role getParent() {
		return parent;
	}
	
	public void setParent(Role parent) {
		this.parent = parent;
	}
	
	public Set<Role> getChilds() {
		return childs;
	}
	
	public void setChilds(Set<Role> childs) {
		this.childs = childs;
	}
	
	public Set<Permission> getPermissions() {
		return permissions;
	}
	
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	
	public String getRawAddTime() {
		return rawAddTime;
	}
	
	public void setRawAddTime(String rawAddTime) {
		this.rawAddTime = rawAddTime;
	}
	
	public String getRawUpdateTime() {
		return rawUpdateTime;
	}
	
	public void setRawUpdateTime(String rawUpdateTime) {
		this.rawUpdateTime = rawUpdateTime;
	}
	
	@Override
	public String toString() {
		return ToString.toString(this);
	}
}
