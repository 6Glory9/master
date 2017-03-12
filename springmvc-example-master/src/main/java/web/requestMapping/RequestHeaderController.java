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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import web.BaseController;

/**
 * @author jxilong@yiji.com
 */
@Controller
@RequestMapping("requestHeader")
public class RequestHeaderController extends BaseController {

    @RequestMapping("test")
    public void test(@RequestHeader("Accept-Encoding") String encode, @RequestHeader("Accept") String accept) {
        logger.info("RequestHeaderController test encoding[{}],keepAlive[{}]", encode, accept);
        //request:http://localhost:8080/requestHeader/test.htm
    }
}
