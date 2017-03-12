/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-18 23:19 创建
 *
 */
package hibernate.xml.basictype;

import com.yjf.common.lang.enums.GenderEnum;
import com.yjf.common.lang.util.money.Money;
import com.yjf.common.util.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jxilong@yiji.com
 */

public class BasicType implements Serializable {
    private static final long serialVersionUID = -1576928463034284482L;

    private Long id;

    private String userName;

    private int age;

    private GenderEnum gender;

    private Date birthday;

    private Date rawAddTime;

    private Date rawUpdateTime;

    private byte[] img;

    private byte[] infoDesc;

    private Money money;

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public void setGender(GenderEnum gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public byte[] getInfoDesc() {
        return infoDesc;
    }

    public void setInfoDesc(byte[] infoDesc) {
        this.infoDesc = infoDesc;
    }

    public Money getMoney() {
        return money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
