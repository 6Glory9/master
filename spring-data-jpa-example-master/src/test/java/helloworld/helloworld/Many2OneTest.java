/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-27 20:48 创建
 *
 */
package helloworld.helloworld;

import helloworld.AbstractSpringDataJPABaseTest;
import jpa.entities.relation.many2one.Order;
import jpa.entities.relation.many2one.OrderItem;
import org.junit.Test;

import javax.persistence.EntityManager;

/**
 * @author jxilong@yiji.com
 */
public class Many2OneTest extends AbstractSpringDataJPABaseTest{

    @Test
    public void save() {
        EntityManager entityManager =  entityManagerFactory.createEntityManager();

        Order order = new Order();
        order.setName("glory");

        OrderItem orderItem = new OrderItem();
        orderItem.setName("orderItem");

        order.getOrderItems().add(orderItem);
        orderItem.setOrderTest(order);

        entityManager.getTransaction().begin();
        entityManager.persist(order);

        entityManager.getTransaction().commit();
    }

    @Test
    public void casedDelete() {
        save();
        EntityManager entityManager =  entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Order order = entityManager.find(Order.class, 1L);
       // order.setOrderItems(null);
        entityManager.remove(order);
        entityManager.getTransaction().commit();
    }
}
