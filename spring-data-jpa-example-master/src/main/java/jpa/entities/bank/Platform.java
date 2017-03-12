/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-24 21:43 创建
 *
 */
package jpa.entities.bank;

import com.yjf.common.util.ToString;

import javax.persistence.*;

/**
 * @author jxilong@yiji.com
 */
@Entity
@Table(name="t_platform")
public class Platform extends BaseEntity {

    @Column(name="login_name",nullable = false,length = 128)
    private String loginName;

    @Column(name="login_password",length = 128)
    private String loginPassword;

    @Column(name="payment_password",length = 128)
    private String paymentPassword;

    @Enumerated(EnumType.STRING)
    @Column(name="platform_type",length = 128,nullable = false)
    private PlatformTypeEnum platformType;

    private MoneyValue moneyValue;


    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public String getPaymentPassword() {
        return paymentPassword;
    }

    public void setPaymentPassword(String paymentPassword) {
        this.paymentPassword = paymentPassword;
    }

    public PlatformTypeEnum getPlatformType() {
        return platformType;
    }

    public void setPlatformType(PlatformTypeEnum platformType) {
        this.platformType = platformType;
    }

    public MoneyValue getMoneyValue() {
        return moneyValue;
    }

    public void setMoneyValue(MoneyValue moneyValue) {
        this.moneyValue = moneyValue;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
