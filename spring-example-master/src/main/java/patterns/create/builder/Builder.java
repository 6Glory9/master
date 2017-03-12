/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2016-03-31 14:31 创建
 *
 */
package patterns.create.builder;

/**
 * @author jxilong@yiji.com
 * 用来创建复合对象，所谓复合对象就是指某个类具有不同的属性
 * 多个一个导演的角色，多个组装场情
 *
 */
public class Builder {

    private Product product;

    public void setProduct(Product product) {
        this.product = product;
    }

    public Product createProduct() {
        //xxx
        return product;
    }
}
