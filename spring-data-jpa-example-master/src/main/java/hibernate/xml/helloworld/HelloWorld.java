/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-18 22:27 创建
 *
 */
package hibernate.xml.helloworld;

import com.yjf.common.util.ToString;

import java.io.Serializable;

/**
 * @author jxilong@yiji.com
 */
public class HelloWorld implements Serializable {
    private static final long serialVersionUID = -6419559999703582795L;

    private Long id;

    private String userName;

    private String sex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
