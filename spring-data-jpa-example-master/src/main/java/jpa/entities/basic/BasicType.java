/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-26 21:28 创建
 *
 */
package jpa.entities.basic;

import com.yjf.common.lang.enums.GenderEnum;
import com.yjf.common.util.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author jxilong@yiji.com
 */
@Entity(name = "t_basict_type_entity")
@Table(
        name = "t_jpa_basic_type",
        indexes = {@Index(name = "idx_real_name",columnList = "real_name",unique = true)},
        uniqueConstraints = {@UniqueConstraint(name = "up_time",columnNames = {"birthday","rawAddTime"})}
)
public class BasicType implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="user_name",length = 128,nullable = false,unique = true)
    //这个唯一约束是系统命名
    private String userName;

    @Column(name="real_name",length = 128,nullable = false)
    private String realName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender",length = 10,nullable = false)
    private GenderEnum gender;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    private Date rawAddTime;

    @Transient
    private Date rawUpdateTime;

    @Lob
    //big text
    private String info;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    //byte
    private byte[] img;

    @Column(name="balance",scale =2 ,precision =17)
    private BigDecimal balance;

    @Version
    //version integer not null,
    private int version;


    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
