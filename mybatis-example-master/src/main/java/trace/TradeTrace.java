/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2016-02-05 21:01 创建
 *
 */
package trace;

import com.yjf.common.util.ToString;

import java.io.Serializable;

/**
 * @author jxilong@yiji.com
 */
public class TradeTrace implements Serializable{

    private String payerAccountNo;

    private String payeeAccountNo;

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

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
