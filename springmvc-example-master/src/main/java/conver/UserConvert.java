/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-11-21 18:00 创建
 *
 */
package conver;

import form.User;
import org.springframework.core.convert.converter.Converter;

/**
 * @author jxilong@yiji.com
 */
public class UserConvert implements Converter<String, User> {


    @Override
    public User convert(String userInfo) {
        String[] itmes = userInfo.split(":");
        User user = new User();
        user.setUserName(itmes[0]);
        user.setPassword(itmes[1]);
        return user;
    }
}
