/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-11-21 16:03 创建
 *
 */
package web.requestMapping;

import form.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import web.BaseController;

/**
 * @author jxilong@yiji.com
 */
@RequestMapping("form")
@Controller
public class FormController extends BaseController {

    @RequestMapping("test")
    public void test(User user) {
        logger.info("FormController test user[{}]", user);
        //request:http://localhost:8080/form/test.htm?userName=glory&password=password
    }
}
