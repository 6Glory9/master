package enums;

import com.yjf.common.lang.enums.Messageable;

public enum PaymentModelEnum implements Messageable {

    DEPOSITE("0", "DEPOSITE"),
    DEPOSITE_BACK("1", "DEPOSITE_BACK"),
    WITHDRAW("3", "WITHDRAW"),
    WITHDRAW_BACK("4", "WITHDRAW_BACK"),
    PAYER("5", "PAYER"),
    PAYEE("6", "PAYEE"),;

    /**
     * 枚举值
     */
    private final String code;

    /**
     * 枚举描述
     */
    private final String message;

    /**
     * @param code    枚举值
     * @param message 枚举描述
     */
    PaymentModelEnum(String code, String message) {
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
    public static PaymentModelEnum getByCode(String code) {
        for (PaymentModelEnum _enum : values()) {
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
    public static java.util.List<PaymentModelEnum> getAllEnum() {
        java.util.List<PaymentModelEnum> list = new java.util.ArrayList<PaymentModelEnum>(
                values().length);
        for (PaymentModelEnum _enum : values()) {
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
        for (PaymentModelEnum _enum : values()) {
            list.add(_enum.code());
        }
        return list;
    }

    /**
     * 通过code获取msg
     *
     * @param code 枚举值
     * @return
     */
    public static String getMsgByCode(String code) {
        if (code == null) {
            return null;
        }
        PaymentModelEnum _enum = getByCode(code);
        if (_enum == null) {
            return null;
        }
        return _enum.getMessage();
    }

    /**
     * 获取枚举code
     *
     * @param _enum
     * @return
     */
    public static String getCode(PaymentModelEnum _enum) {
        if (_enum == null) {
            return null;
        }
        return _enum.getCode();
    }
}
