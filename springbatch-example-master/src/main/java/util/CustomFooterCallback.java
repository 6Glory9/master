/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-09-19 11:32 创建
 *
 */
package util;

import org.springframework.batch.item.file.FlatFileFooterCallback;

import java.io.IOException;
import java.io.Writer;

/**
 * @author jxilong@yiji.com
 */
public class CustomFooterCallback implements FlatFileFooterCallback {
	
	@Override
	public void writeFooter(Writer writer) throws IOException {
		writer.write("end");
	}
}
