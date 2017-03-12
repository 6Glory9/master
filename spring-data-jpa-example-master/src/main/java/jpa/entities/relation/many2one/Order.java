/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-27 18:53 创建
 *
 */
package jpa.entities.relation.many2one;

import com.yjf.common.util.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author jxilong@yiji.com
 */
@Entity
@Table(name="t_order")
public class Order implements Serializable {
    private static final long serialVersionUID = 2844232810412667724L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    /**
     * ToMany fetch default=LAZY
     * targetEntity 如果集合没有使用泛型，就要指定targetEntity.如果使用泛型可以使用反射
     * orphanRemoval 级联删除，集合既是不存在值也没有做到级联删除
     * mappedBy 标示关系维护的属性
     * cascade 级联操作，存在相应的值才能相应操作
     */
    @OneToMany(fetch = FetchType.LAZY,targetEntity = OrderItem.class,mappedBy = "orderTest" ,cascade = CascadeType.PERSIST,orphanRemoval = true)
    private Set<OrderItem> orderItems = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
