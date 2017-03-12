package enums;

import com.yjf.common.lang.enums.Messageable;

public enum ExceptionEnum implements Messageable {

	CURRENCY_IS_NOT_MATH("CURRENCY_IS_NOT_MATH", "币种不匹配"),

	BALANCE_IS_NOT_ENOUGH("BALANCE_IS_NOT_ENOUGH", "余额不足够"),

	ILLEGAL_PAYMENT_MODEL("ILLEGAL_PAYMENT_MODEL", "非法支付模型"),

	ILLEGAL_STATUS("ILLEGAL_STATUS", "非法状态"),

	NO_OWN_ABILITY("NO_OWN_ABILITY", "无支付能力"),

	;

	/** 枚举值 */
	private final String	code;

	/** 枚举描述 */
	private final String	message;

	/**
	 *
	 * @param code 枚举值
	 * @param message 枚举描述
	 */
	ExceptionEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String getMessage() {
		return message;
	}
	
	/**
	 * @return Returns the code.
	 */
	public String code() {
		return code;
	}
	
	/**
	 * @return Returns the message.
	 */
	public String message() {
		return message;
	}
	
	/**
	 * 通过枚举<code>code</code>获得枚举
	 *
	 * @param code
	 * @return AutoConfigBizTypeEnum
	 */
	public static ExceptionEnum getByCode(String code) {
		for (ExceptionEnum _enum : values()) {
			if (_enum.getCode().equals(code)) {
				return _enum;
			}
		}
		return null;
	}
	
	/**
	 * 获取全部枚举
	 * 
	 * @return List<AutoConfigBizTypeEnum>
	 */
	public static java.util.List<ExceptionEnum> getAllEnum() {
		java.util.List<ExceptionEnum> list = new java.util.ArrayList<ExceptionEnum>(
			values().length);
		for (ExceptionEnum _enum : values()) {
			list.add(_enum);
		}
		return list;
	}
	
	/**
	 * 获取全部枚举值
	 * 
	 * @return List<String>
	 */
	public static java.util.List<String> getAllEnumCode() {
		java.util.List<String> list = new java.util.ArrayList<String>(values().length);
		for (ExceptionEnum _enum : values()) {
			list.add(_enum.code());
		}
		return list;
	}
	
	/**
	 * 通过code获取msg
	 * @param code 枚举值
	 * @return
	 */
	public static String getMsgByCode(String code) {
		if (code == null) {
			return null;
		}
		ExceptionEnum _enum = getByCode(code);
		if (_enum == null) {
			return null;
		}
		return _enum.getMessage();
	}
	
	/**
	 * 获取枚举code
	 * @param _enum
	 * @return
	 */
	public static String getCode(ExceptionEnum _enum) {
		if (_enum == null) {
			return null;
		}
		return _enum.getCode();
	}
}
