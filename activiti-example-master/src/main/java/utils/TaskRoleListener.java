/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-13 16:55 创建
 *
 */
package utils;


import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * @author jxilong@yiji.com
 */
public class TaskRoleListener implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.addCandidateUser("xiaoming");
    }
}
