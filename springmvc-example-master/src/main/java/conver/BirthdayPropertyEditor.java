/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-07-18 23:24 创建
 *
 */
package conver;

import com.yjf.common.lang.util.DateUtil;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;

/**
 * @author jxilong@yiji.com
 */
public class BirthdayPropertyEditor extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String birthday) {
		Date date = null;
		try {
			date = DateUtil.parseDateNoTime(birthday, "yyyyMMdd");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		setValue(date);
	}
	
	@Override
	public String getAsText() {
		Date value = (Date) getValue();
		return (value != null ? DateUtil.shortDate(value) : null);
	}
}
