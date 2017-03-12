/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-02 22:29 创建
 *
 */
package exeptions;

import enums.ExceptionEnum;

/**
 * @author jxilong@yiji.com
 */
public class BusinessException extends RuntimeException {
	
	private ExceptionEnum exception;
	
	public ExceptionEnum getException() {
		return exception;
	}
	
	public void setException(ExceptionEnum exception) {
		this.exception = exception;
	}
	
	public BusinessException(ExceptionEnum exception) {
		this.exception = exception;
	}
	
	public BusinessException(String message, ExceptionEnum exception) {
		super(message);
		this.exception = exception;
	}
	
	public BusinessException(String message, Throwable cause, ExceptionEnum exception) {
		super(message, cause);
		this.exception = exception;
	}
	
	public BusinessException(Throwable cause, ExceptionEnum exception) {
		super(cause);
		this.exception = exception;
	}
	
	public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace,
								ExceptionEnum exception) {
		super(message, cause, enableSuppression, writableStackTrace);
		this.exception = exception;
	}
}
