/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2016-03-31 16:31 创建
 *
 */
package patterns.action.template;

/**
 * @author jxilong@yiji.com
 * 模板方法定义成固定的整个流程
 * 基本方法，由子类实现具体的做法
 * 钩子方法，子类可以覆盖此方法，改变父类的行为
 * 达到父类调用子类方式
 */
public abstract class Template {
	
	protected abstract void basicMethod();
	
	protected void hookMethod() {
		//do something
	}
	
	public final void template() {
        basicMethod();
        //....
        hookMethod();
    }
}
