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

import org.springframework.batch.item.file.FlatFileHeaderCallback;

import java.io.IOException;
import java.io.Writer;

/**
 * @author jxilong@yiji.com
 */
public class CustomHeaderCallback implements FlatFileHeaderCallback {
	

	@Override
	public void writeHeader(Writer writer) throws IOException {
		writer.write("header");
	}
}
