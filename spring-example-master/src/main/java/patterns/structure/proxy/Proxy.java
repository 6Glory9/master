/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2016-03-31 15:27 创建
 *
 */
package patterns.structure.proxy;

import patterns.structure.adapter.Source;
import patterns.structure.decorator.Sourceable;

/**
 * @author jxilong@yiji.com
 */
public class Proxy implements Sourceable {

    private Source source = new Source();

    @Override
    public void method() {
        //first
        source.method();
        //second
    }
}
