/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-24 21:44 创建
 *
 */
package jpa.entities.bank;

/**
 * @author jxilong@yiji.com
 */
public enum PlatformTypeEnum {
    YJF("YJF","重庆易极付科技有限公司")


    ;

    private String  companyCode;

    private String companyName;

    PlatformTypeEnum(String companyCode, String companyName) {
        this.companyCode = companyCode;
        this.companyName = companyName;
    }
}
