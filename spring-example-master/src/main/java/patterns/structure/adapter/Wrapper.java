/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2016-03-31 14:44 创建
 *
 */
package patterns.structure.adapter;

/**
 * @author jxilong@yiji.com
 * 1.类适配方式
 * 2.对象适配方式
 * 3.接口的适配器
 *
 */
public class Wrapper implements Targetable {

    private Source source = new Source();

    @Override
    public void method() {
        source.method();
    }

    @Override
    public void method2() {

    }
}
