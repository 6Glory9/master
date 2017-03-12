/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-09-18 22:29 创建
 *
 */
package util;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

/**
 * @author jxilong@yiji.com
 */
public class CustomIncrementer implements JobParametersIncrementer {

	private static String RUN_ID_KEY = "run.id";
	
	private String key = RUN_ID_KEY;
	
	/**
	 * The name of the run id in the job parameters. Defaults to "run.id".
	 *
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	
	/**
	 * Increment the run.id parameter (starting with 1).
	 */
	public JobParameters getNext(JobParameters parameters) {
		
		JobParameters params = (parameters == null) ? new JobParameters() : parameters;
		
		long id = params.getLong(key, 0L) + 1;
		return new JobParametersBuilder(params).addLong(key, id).toJobParameters();
	}
}
