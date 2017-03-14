package form;

import com.yjf.common.util.ToString;

import java.io.Serializable;

/**
 * Created by jxilong on 2017/3/14.
 */
public class CqInfo implements Serializable {

    private String id;

    private String createTime;

    private String userName;

    private String companyName;

    private String personalMoney;

    private String companyMoney;

    private String accountNo;

    private String balance;

    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPersonalMoney() {
        return personalMoney;
    }

    public void setPersonalMoney(String personalMoney) {
        this.personalMoney = personalMoney;
    }

    public String getCompanyMoney() {
        return companyMoney;
    }

    public void setCompanyMoney(String companyMoney) {
        this.companyMoney = companyMoney;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
