/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-24 21:11 创建
 *
 */
package jpa.entities.bank;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jxilong@yiji.com
 */
@Entity
@Table(name = "t_user")
public class User extends BaseEntity {


    @Column(name="real_name",nullable = false,length = 128)
    private String realName;

    @OneToOne
    @JoinColumn(name="id_card")
    private IdCard idCard;

    /**
     * targetEntity:Set<Bank>如果 Collection 不使用一般参数，则必须指定作为关联目标的实体类：
     * 将关联拥有方上的 targetEntity 元素设置为作为关系目标的实体的 Class。
     */
    @OneToMany(targetEntity = Bank.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL )
    @JoinColumn(name="user_id")
    private Set<Bank> banks = new HashSet<>();


    @OneToMany
    @JoinColumn(name="user_id")
    private Set<Platform> platforms = new HashSet<>();


    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public IdCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IdCard idCard) {
        this.idCard = idCard;
    }

    public Set<Bank> getBanks() {
        return banks;
    }

    public void setBanks(Set<Bank> banks) {
        this.banks = banks;
    }

    public Set<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(Set<Platform> platforms) {
        this.platforms = platforms;
    }
}
