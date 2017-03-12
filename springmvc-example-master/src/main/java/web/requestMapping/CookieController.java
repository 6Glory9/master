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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import web.BaseController;

/**
 * @author jxilong@yiji.com
 */
@RequestMapping("cookie")
@Controller
public class CookieController extends BaseController{

    @RequestMapping("test")
    public void test(@CookieValue(value = "cookie",required = false) String sessionId) {
        logger.info("CookieController test sessionId[{}]",sessionId);
        //request:http://localhost:8080/cookie/test.htm
    }
}
