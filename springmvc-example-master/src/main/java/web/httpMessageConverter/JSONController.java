/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-11-21 17:09 创建
 *
 */
package web.httpMessageConverter;

import form.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import web.BaseController;

/**
 * @author jxilong@yiji.com
 */
@Controller
@RequestMapping("json")
public class JSONController extends BaseController {

    @RequestMapping("test")
    @ResponseBody
    public User test() {
        return new User();
    }
}
