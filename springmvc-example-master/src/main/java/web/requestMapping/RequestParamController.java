/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-11-21 15:47 创建
 *
 */
package web.requestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.BaseController;

/**
 * @author jxilong@yiji.com
 */
@RequestMapping("requestParam")
@Controller
public class RequestParamController extends BaseController {

    @RequestMapping("test")
    public void test(@RequestParam("name") String username, @RequestParam(required = false) int age) {
        logger.info("RequestParamController test userName[{}], aget[{}] ", username, age);
        //request:http://localhost:8080/requestParam/test.htm?name=tt&age=11
    }
}
