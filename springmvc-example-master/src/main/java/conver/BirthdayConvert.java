/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-07-18 23:12 创建
 *
 */
package conver;

import com.yjf.common.lang.util.DateUtil;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.util.Date;

/**
 * @author jxilong@yiji.com
 */
public class BirthdayConvert implements Converter<String, Date> {
	
	@Override
	public Date convert(String birthday) {
		try {
			return DateUtil.parseDateNoTime(birthday, "yyyy-MM-dd");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
