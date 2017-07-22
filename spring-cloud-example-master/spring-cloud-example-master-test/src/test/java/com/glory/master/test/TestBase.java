/*
 * www.yiji.com Inc.
 * Copyright (c) 2015 All Rights Reserved
 */

package com.glory.master.test;

import com.yiji.boot.core.Apps;
import com.yiji.boot.test.AppWebTestBase;
import org.springframework.boot.test.SpringApplicationConfiguration;
import com.glory.master.Main;

/**
 * @author qiubo@yiji.com
 */
@SpringApplicationConfiguration(classes = Main.class)
public abstract class TestBase extends AppWebTestBase {
	protected static final String PROFILE = "sdev";
	
	static {
		Apps.setProfileIfNotExists(PROFILE);
	}
	
}
