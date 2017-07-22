package entity.account;

import java.io.Serializable;

/**
 * Created by jxilong on 2017/7/22.
 */
public class Transfer implements Serializable {

    private String bizNo;

    private String userId;


    public String getBizNo() {
        return bizNo;
    }

    public void setBizNo(String bizNo) {
        this.bizNo = bizNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Transfer{");
        sb.append("bizNo='").append(bizNo).append('\'');
        sb.append(", userId='").append(userId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
