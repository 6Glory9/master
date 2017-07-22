/*
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved
 */
package com.glory.master;

import com.yiji.boot.core.Apps;
import org.springframework.boot.SpringApplication;
import com.yiji.boot.core.YijiBootApplication;


/**
 * @author qiubo@yiji.com
 */
@YijiBootApplication(sysName = "spring-cloud-example-master", httpPort = 8080)
public class Main {
    public static void main(String[] args) {
        Apps.setProfileIfNotExists("sdev");
        new SpringApplication(Main.class).run(args);
    }
}