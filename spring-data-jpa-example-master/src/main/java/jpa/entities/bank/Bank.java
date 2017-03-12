/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-24 21:11 创建
 *
 */
package jpa.entities.bank;

import com.yjf.common.payengine.enums.BankCodeEnum;
import com.yjf.common.util.ToString;

import javax.persistence.*;

/**
 * @author jxilong@yiji.com
 */
@Entity
@Table(name="t_bank")
public class Bank  extends BaseEntity{

    @Enumerated(EnumType.STRING)
    @Column(name="bank_code",length = 20,nullable = false)
    private BankCodeEnum bankCode;

    @Column(name="bank_no",length = 20,nullable = false)
    private String bankNo;

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name="balance",column = @Column(name = "available_Balance"))
    )
    private MoneyValue moneyValue;

    private String bindMobile;

    private String address;

    public BankCodeEnum getBankCode() {
        return bankCode;
    }

    public void setBankCode(BankCodeEnum bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
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
