package utils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jxilong on 2017/3/14.
 */
public enum ConvertEnum {
	
							VIEW_STATE("#__VIEWSTATE", "__VIEWSTATE"),
							VIEW_STATE_GENERATOR("#__VIEWSTATEGENERATOR", "__VIEWSTATEGENERATOR"),
							EVENT_VALIDATION("#__EVENTVALIDATION", "__EVENTVALIDATION"),
							
							CONTENTPLACEHOLDER1_LABEL1("#ContentPlaceHolder1_Label1", "id"),
							CONTENTPLACEHOLDER1_LB_KHSJ("#ContentPlaceHolder1_lb_khsj", "createTime"),
							CONTENTPLACEHOLDER1_LB_NAME("#ContentPlaceHolder1_lb_name", "userName"),
							CONTENTPLACEHOLDER1_LB_DWMC("#ContentPlaceHolder1_lb_dwmc", "companyName"),
							CONTENTPLACEHOLDER1_LB_GRJJE("#ContentPlaceHolder1_lb_grjje", "personalMoney"),
							CONTENTPLACEHOLDER1_LB_DWYJE("#ContentPlaceHolder1_lb_dwyje", "companyMoney"),
							CONTENTPLACEHOLDER1_LB_GRJJJZH("#ContentPlaceHolder1_lb_grjjjzh", "accountNo"),
							CONTENTPLACEHOLDER1_LB_DQYE("#ContentPlaceHolder1_lb_dqye", "balance"),
							CONTENTPLACEHOLDER1_LB_DWZCS("#ContentPlaceHolder1_lb_dwzcs", "status"),
	
	;
	
	public static List<ConvertEnum> getLogin() {
		return Arrays.asList(VIEW_STATE, VIEW_STATE_GENERATOR, EVENT_VALIDATION);
	}
	
	public static List<ConvertEnum> getInfo() {
		return Arrays.asList(CONTENTPLACEHOLDER1_LABEL1, CONTENTPLACEHOLDER1_LB_KHSJ, CONTENTPLACEHOLDER1_LB_NAME,
			CONTENTPLACEHOLDER1_LB_DWMC, CONTENTPLACEHOLDER1_LB_GRJJE, CONTENTPLACEHOLDER1_LB_DWYJE,
			CONTENTPLACEHOLDER1_LB_GRJJJZH, CONTENTPLACEHOLDER1_LB_DQYE, CONTENTPLACEHOLDER1_LB_DWZCS);
	}
	
	/**
	 * 从html解析出的selectKey
	 */
	private String selectKey;
	
	/**
	 * form表单name
	 */
	private String inputTextName;
	
	ConvertEnum(String selectKey, String inputTextName) {
		this.selectKey = selectKey;
		this.inputTextName = inputTextName;
	}
	
	public String getSelectKey() {
		return selectKey;
	}
	
	public String getInputTextName() {
		return inputTextName;
	}
}
