package form;

import com.yjf.common.util.ToString;

import java.io.Serializable;

/**
 * Created by jxilong on 2016/7/10.
 */
public class AjaxResult implements Serializable {

    private String message;

    private String code;

    private String status;

    private Object  data;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
