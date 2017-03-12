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

/**
 * @author jxilong@yiji.com
 */
@Entity
@Table(name="t_order_item")
public class OrderItem implements Serializable {
    private static final long serialVersionUID = -4709328330051687953L;

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    /**
     * optional 表示可选，可以为空不
     *
     */
    @ManyToOne(optional = false)
    @JoinColumn(name="order_id")
    private Order orderTest;

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

    public Order getOrderTest() {
        return orderTest;
    }

    public void setOrderTest(Order orderTest) {
        this.orderTest = orderTest;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
