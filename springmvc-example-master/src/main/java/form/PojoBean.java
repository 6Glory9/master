/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-07-27 21:49 创建
 *
 */
package form;

import com.yjf.common.lang.enums.GenderEnum;
import com.yjf.common.util.ToString;

/**
 * @author jxilong@yiji.com
 */
public class PojoBean {

    private GenderEnum gender;

    private String userName;

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
