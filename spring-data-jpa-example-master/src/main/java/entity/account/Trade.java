/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-03 21:32 创建
 *
 */
package entity.account;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.payengine.enums.CurrencyEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jxilong@yiji.com
 */
public class Trade implements Serializable {

    private static final long serialVersionUID = 7734101348068573129L;
    private Long identity;
    /*外部订单号*/
    private String outOrderNo;
    /*商户请求号*/
    private String merchantOrderNo;
    /*账务流水号*/
    private String bizNo;
    /*交易金额*/
    private Money transMoney;
    /* 币种*/
    private CurrencyEnum currency;
    /*转出资金账号*/
    private String payerAccountNo;
    /*转入资金账号*/
    private String payeeAccountNo;

    private String memo;

    private Date rawAddTime;

    private Date rawUpdateTime;

    public Long getIdentity() {
        return identity;
    }

    public void setIdentity(Long identity) {
        this.identity = identity;
    }

    public String getOutOrderNo() {
        return outOrderNo;
    }

    public void setOutOrderNo(String outOrderNo) {
        this.outOrderNo = outOrderNo;
    }

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    public String getBizNo() {
        return bizNo;
    }

    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }

    public Money getTransMoney() {
        return transMoney;
    }

    public void setTransMoney(Money transMoney) {
        this.transMoney = transMoney;
    }

    public CurrencyEnum getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyEnum currency) {
        this.currency = currency;
    }

    public String getPayerAccountNo() {
        return payerAccountNo;
    }

    public void setPayerAccountNo(String payerAccountNo) {
        this.payerAccountNo = payerAccountNo;
    }

    public String getPayeeAccountNo() {
        return payeeAccountNo;
    }

    public void setPayeeAccountNo(String payeeAccountNo) {
        this.payeeAccountNo = payeeAccountNo;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getRawAddTime() {
        return rawAddTime;
    }

    public void setRawAddTime(Date rawAddTime) {
        this.rawAddTime = rawAddTime;
    }

    public Date getRawUpdateTime() {
        return rawUpdateTime;
    }

    public void setRawUpdateTime(Date rawUpdateTime) {
        this.rawUpdateTime = rawUpdateTime;
    }
}
