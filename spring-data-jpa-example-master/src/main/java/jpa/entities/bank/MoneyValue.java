/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-24 21:47 创建
 *
 */
package jpa.entities.bank;

import com.yjf.common.lang.util.money.Money;
import com.yjf.common.util.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * @author jxilong@yiji.com
 */
@Embeddable
public class MoneyValue implements Serializable {

    @Column(name="balance",scale = 17,precision = 0)
    private Money balance;

    @Column(name="min_money",scale = 17,precision = 0)
    private Money minMoney;

    @Column(name="max_money",scale = 17,precision = 0)
    private Money maxMoney;


    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public Money getMinMoney() {
        return minMoney;
    }

    public void setMinMoney(Money minMoney) {
        this.minMoney = minMoney;
    }

    public Money getMaxMoney() {
        return maxMoney;
    }

    public void setMaxMoney(Money maxMoney) {
        this.maxMoney = maxMoney;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
