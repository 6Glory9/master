/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-11-22 11:55 创建
 *
 */
package form;

import com.yjf.common.util.ToString;
import form.validator.Gid;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * @author jxilong@yiji.com
 */
public class UserValid implements Serializable {

    @Gid
    private String gid;

    @NotBlank(message = "{UserValid.userId}")
    private String userId;

    @Pattern(regexp = "w{4,30}",message = "{UserValid.userName}")
    private String userName;

    @Pattern(regexp = "S{6,30}",message = "{UserValid.password}")
    private String password;

    @Past(message = "{UserValid.birthday}")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date birthday;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
