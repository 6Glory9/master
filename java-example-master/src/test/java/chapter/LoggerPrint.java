/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2016-02-04 20:01 创建
 *
 */
package chapter;

import org.slf4j.Logger;

/**
 * @author jxilong@yiji.com
 */
public class LoggerPrint implements Print{

    public static Logger logger = org.slf4j.LoggerFactory.getLogger(LoggerPrint.class);


    @Override
    public void print(String message) {
        logger.info(message);
    }
}
