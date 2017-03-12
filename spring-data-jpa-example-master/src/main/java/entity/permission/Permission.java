/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-05 11:56 创建
 *
 */
package entity.permission;

import com.yjf.common.util.ToString;
import enums.PermissionTypeEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jxilong@yiji.com
 */
public class Permission implements Serializable {

     /*id*/
    private Long id;
    /*权限值*/
    private String permissionKey;

    /*权限名字*/
    private String permissionName;

    /*访问URL(system+url)*/
    private String url;

    /*解决可配置问题*/
    private System system;

    /*URL_PERMISSION时才有SYSTEM+URL*/
    private PermissionTypeEnum permissionType;

    private String memo;

    private Date rawAddTime;

    private Date rawUpadateTime;

    public PermissionTypeEnum getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(PermissionTypeEnum permissionType) {
        this.permissionType = permissionType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionKey() {
        return permissionKey;
    }

    public void setPermissionKey(String permissionKey) {
        this.permissionKey = permissionKey;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    public Date getRawAddTime() {
        return rawAddTime;
    }

    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    public Date getRawUpadateTime() {
        return rawUpadateTime;
    }

    public void setRawUpadateTime(Date rawUpadateTime) {
        this.rawUpadateTime = rawUpadateTime;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
