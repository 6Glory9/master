/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-03 21:11 创建
 *
 */
package entity.account;

import com.yjf.common.lang.enums.BalanceDirectionEnum;
import com.yjf.common.lang.util.money.Money;
import com.yjf.common.payengine.enums.CurrencyEnum;
import com.yjf.common.util.ToString;
import enums.TradeTypeEnum;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jxilong@yiji.com
 */
public class AccountLog implements Serializable {
	
	private static final long serialVersionUID = 8734858385215495227L;
	
	private Long identity;
	
	/*外部订单号*/
	private String outOrderNo;
	/*商户请求号*/
	private String merchantOrderNo;
	/*账务流水号*/
	private String bizNo;
	/*清算流水号*/
	private String settleOrderNo;
	
	private String userId;
	
	private String cardNo;
	
	private String accountNo;
	/*会计科目*/
	private String accountTitleId;
	/*交易金额*/
	private Money transMoney;
	/*交易类型*/
	private TradeTypeEnum tradeType;
	/* 币种*/
	private CurrencyEnum currency;
	/*方向*/
	private BalanceDirectionEnum direction;
	/*当前余额*/
	private Money balance;
	/*当前可用余额*/
	private Money creditBalance;
	/*当前冻结余额*/
	private Money freezeMoney;
	/*对手方账号(accountNo,masterBankNo)*/
	private String opAccount;
	/*交易关联号,tradeBizNo*/
	private String tradeBizNo;
	/*核算码*/
	private String accountCode;
	/*备注*/
	private String memo;
	
	private Date rawAddTime;
	
	private Date rawUpdateTime;
	
	public String getTradeBizNo() {
		return tradeBizNo;
	}
	
	public void setTradeBizNo(String tradeBizNo) {
		this.tradeBizNo = tradeBizNo;
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
	
	public String getSettleOrderNo() {
		return settleOrderNo;
	}
	
	public void setSettleOrderNo(String settleOrderNo) {
		this.settleOrderNo = settleOrderNo;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getCardNo() {
		return cardNo;
	}
	
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getAccountTitleId() {
		return accountTitleId;
	}
	
	public void setAccountTitleId(String accountTitleId) {
		this.accountTitleId = accountTitleId;
	}
	
	public Money getTransMoney() {
		return transMoney;
	}
	
	public void setTransMoney(Money transMoney) {
		this.transMoney = transMoney;
	}
	
	public TradeTypeEnum getTradeType() {
		return tradeType;
	}
	
	public void setTradeType(TradeTypeEnum tradeType) {
		this.tradeType = tradeType;
	}
	
	public CurrencyEnum getCurrency() {
		return currency;
	}
	
	public void setCurrency(CurrencyEnum currency) {
		this.currency = currency;
	}
	
	public BalanceDirectionEnum getDirection() {
		return direction;
	}
	
	public void setDirection(BalanceDirectionEnum direction) {
		this.direction = direction;
	}
	
	public Money getBalance() {
		return balance;
	}
	
	public void setBalance(Money balance) {
		this.balance = balance;
	}
	
	public Money getCreditBalance() {
		return creditBalance;
	}
	
	public void setCreditBalance(Money creditBalance) {
		this.creditBalance = creditBalance;
	}
	
	public Money getFreezeMoney() {
		return freezeMoney;
	}
	
	public void setFreezeMoney(Money freezeMoney) {
		this.freezeMoney = freezeMoney;
	}
	
	public String getOpAccount() {
		return opAccount;
	}
	
	public void setOpAccount(String opAccount) {
		this.opAccount = opAccount;
	}
	
	public String getAccountCode() {
		return accountCode;
	}
	
	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}
	
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public Long getIdentity() {
		return identity;
	}
	
	public void setIdentity(Long identity) {
		this.identity = identity;
	}
	
	@Override
	public String toString() {
		return ToString.toString(this);
	}
}
