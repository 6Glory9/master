/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-10-24 17:13 创建
 *
 */
package entity.account;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.payengine.enums.CurrencyEnum;
import com.yjf.common.util.ToString;
import enums.AccountStatusEnum;
import enums.ExceptionEnum;
import enums.PaymentModelEnum;
import exeptions.BusinessException;
import utils.PaymentModelUtil;
import values.HistoryMoney;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jxilong@yiji.com
 */

public class Account implements Serializable {
	
	private static final long serialVersionUID = 8022159297852647225L;
	/* 资金账号*/
	private String accountNo;
	
	/* 资金账号别名*/
	private String accountAlias;
	
	private AccountStatusEnum status;
	
	/* 支付模型 */
	private String paymentModel;
	
	/* 会计科目*/
	private String accountTitleId;
	
	/* 会员ID*/
	private String userId;
	
	/* 卡号*/
	private String cardNo;
	
	/* 证件号*/
	private String certNo;
	
	/* 币种*/
	private CurrencyEnum currency;
	
	/* 余额*/
	private Money balance;
	
	/* 信用余额*/
	private Money creditBalance;
	
	/* 信用额度*/
	private Money creditAmount;
	
	/* 冻结金额*/
	private Money freezeMoney;
	
	/* 历史金额*/
	private HistoryMoney historyMoney;
	
	/* 添加时间*/
	private Date rawAddTime;
	
	/* 更新时间*/
	private Date rawUpdateTime;
	
	public String getPaymentModel() {
		return paymentModel;
	}
	
	public void setPaymentModel(String paymentModel) {
		this.paymentModel = paymentModel;
	}
	
	public void deposit(Money depositMoney, CurrencyEnum currency) {
		PaymentModelUtil.hasAbility(PaymentModelEnum.DEPOSITE, getPaymentModel());
		
		addMoney(depositMoney, currency);
		
		historyMoney.getDepositMoneyHistory().addTo(depositMoney);
	}
	
	public void depositBack(Money depositBackMoney, CurrencyEnum currency) {
		PaymentModelUtil.hasAbility(PaymentModelEnum.DEPOSITE_BACK, getPaymentModel());
		subtractMoneyWithoutCreditBalance(depositBackMoney, currency);
		historyMoney.getDepositBackMoneyHistory().addTo(depositBackMoney);
	}
	
	public void withdraw(Money withdrawMoney, CurrencyEnum currency) {
		PaymentModelUtil.hasAbility(PaymentModelEnum.WITHDRAW, getPaymentModel());
		subtractMoney(withdrawMoney, currency);
		historyMoney.getWithdrawMoneyHistory().addTo(withdrawMoney);
	}
	
	public void withdrawBack(Money withdrawBackMoney, CurrencyEnum currency) {
		PaymentModelUtil.hasAbility(PaymentModelEnum.WITHDRAW_BACK, getPaymentModel());
		addMoney(withdrawBackMoney, currency);
		historyMoney.getDepositBackMoneyHistory().addTo(withdrawBackMoney);
	}
	
	public void transfer(Account payeeAmount, Money transferMoney, CurrencyEnum currency) {
		PaymentModelUtil.hasAbility(PaymentModelEnum.PAYER, getPaymentModel());
		PaymentModelUtil.hasAbility(PaymentModelEnum.PAYEE, payeeAmount.getPaymentModel());
		subtractMoney(transferMoney, currency);
		payeeAmount.addMoney(transferMoney, currency);
		
		historyMoney.getPayerHistoryMoney().addTo(transferMoney);
		payeeAmount.getHistoryMoney().getPayeeHistoryMoney().addTo(transferMoney);
	}
	
	private void addMoney(Money depositMoney, CurrencyEnum currency) {
		
		checkStatusAndCurrency(currency);
		
		//1.可信余额没用
		if (creditAmount.equals(creditBalance)) {
			balance.addTo(depositMoney);
			return;
		}
		
		//2.还钱
		creditBalance.addTo(depositMoney);
		
		//3.newCreateBalance>creditAmount
		if (creditBalance.greaterThan(creditAmount)) {
			Money beyondMoney = creditBalance.subtract(creditAmount);
			balance.addTo(beyondMoney);
			creditBalance.subtractFrom(beyondMoney);
		}
	}
	
	private void subtractMoney(Money depositBackMoney, CurrencyEnum currency) {
		checkStatusAndCurrency(currency);
		
		checkBalance(depositBackMoney);
		
		//1.充退
		balance.subtractFrom(depositBackMoney);
		
		//2.余额不足够
		if (lessThan(balance, Money.zero())) {
			creditBalance.addTo(balance);
			balance = Money.zero();
		}
	}
	
	private void subtractMoneyWithoutCreditBalance(Money depositBackMoney, CurrencyEnum currency) {
		checkStatusAndCurrency(currency);
		
		checkBalanceWithoutCreditBalance(depositBackMoney);
		
		balance.subtractFrom(depositBackMoney);
		
	}
	
	private boolean lessThan(Money smallMoney, Money bigMoney) {
		return smallMoney.compareTo(bigMoney) == -1;
	}
	
	private void checkBalance(Money outMoney) {
		if (outMoney.greaterThan(balance.add(creditBalance))) {
			throw new BusinessException(ExceptionEnum.BALANCE_IS_NOT_ENOUGH);
		}
	}
	
	private void checkBalanceWithoutCreditBalance(Money outMoney) {
		if (outMoney.greaterThan(balance)) {
			throw new BusinessException(ExceptionEnum.BALANCE_IS_NOT_ENOUGH);
		}
	}
	
	private void checkStatusAndCurrency(CurrencyEnum currency) {
		if (status != AccountStatusEnum.ACTIVE) {
			throw new BusinessException(ExceptionEnum.ILLEGAL_STATUS);
		}
		
		if (this.currency != currency) {
			throw new BusinessException(ExceptionEnum.CURRENCY_IS_NOT_MATH);
		}
	}
	
	public String getAccountTitleId() {
		return accountTitleId;
	}
	
	public void setAccountTitleId(String accountTitleId) {
		this.accountTitleId = accountTitleId;
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
	
	public String getCertNo() {
		return certNo;
	}
	
	public void setCertNo(String certNo) {
		this.certNo = certNo;
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
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getAccountAlias() {
		return accountAlias;
	}
	
	public void setAccountAlias(String accountAlias) {
		this.accountAlias = accountAlias;
	}
	
	public Money getBalance() {
		return balance;
	}
	
	public void setBalance(Money balance) {
		this.balance = balance;
	}
	
	public CurrencyEnum getCurrency() {
		return currency;
	}
	
	public void setCurrency(CurrencyEnum currency) {
		this.currency = currency;
	}
	
	public AccountStatusEnum getStatus() {
		return status;
	}
	
	public void setStatus(AccountStatusEnum status) {
		this.status = status;
	}
	
	public Money getCreditAmount() {
		return creditAmount;
	}
	
	public void setCreditAmount(Money creditAmount) {
		this.creditAmount = creditAmount;
	}
	
	public HistoryMoney getHistoryMoney() {
		return historyMoney;
	}
	
	public void setHistoryMoney(HistoryMoney historyMoney) {
		this.historyMoney = historyMoney;
	}
	
	@Override
	public String toString() {
		return ToString.toString(this);
	}
}
