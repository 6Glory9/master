/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-02 22:05 创建
 *
 */
package values;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.util.ToString;

import java.io.Serializable;

/**
 * @author jxilong@yiji.com
 */
public class HistoryMoney implements Serializable {
	
	private static final long serialVersionUID = 4313499978357363766L;
	
	private Money depositMoneyHistory;
	
	private Money depositBackMoneyHistory;
	
	private Money withdrawMoneyHistory;
	
	private Money withdrawBackMoneyHistory;
	
	private Money payeeHistoryMoney;
	
	private Money payerHistoryMoney;
	
	public Money getDepositMoneyHistory() {
		return depositMoneyHistory;
	}
	
	public void setDepositMoneyHistory(Money depositMoneyHistory) {
		this.depositMoneyHistory = depositMoneyHistory;
	}
	
	public Money getDepositBackMoneyHistory() {
		return depositBackMoneyHistory;
	}
	
	public void setDepositBackMoneyHistory(Money depositBackMoneyHistory) {
		this.depositBackMoneyHistory = depositBackMoneyHistory;
	}
	
	public Money getWithdrawMoneyHistory() {
		return withdrawMoneyHistory;
	}
	
	public void setWithdrawMoneyHistory(Money withdrawMoneyHistory) {
		this.withdrawMoneyHistory = withdrawMoneyHistory;
	}
	
	public Money getWithdrawBackMoneyHistory() {
		return withdrawBackMoneyHistory;
	}
	
	public void setWithdrawBackMoneyHistory(Money withdrawBackMoneyHistory) {
		this.withdrawBackMoneyHistory = withdrawBackMoneyHistory;
	}
	
	public Money getPayeeHistoryMoney() {
		return payeeHistoryMoney;
	}
	
	public void setPayeeHistoryMoney(Money payeeHistoryMoney) {
		this.payeeHistoryMoney = payeeHistoryMoney;
	}
	
	public Money getPayerHistoryMoney() {
		return payerHistoryMoney;
	}
	
	public void setPayerHistoryMoney(Money payerHistoryMoney) {
		this.payerHistoryMoney = payerHistoryMoney;
	}
	
	@Override
	public String toString() {
		return ToString.toString(this);
	}
}
