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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import web.BaseController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author jxilong@yiji.com
 */
@RequestMapping("servletAPI")
@Controller
public class ServletAPIController extends BaseController {

    @RequestMapping("test")
    public void test(HttpServletRequest request, HttpServletResponse response, HttpSession session, WebRequest webRequest) {
        logger.info("ServletAPIController test request[{}]", request);
        logger.info("ServletAPIController test response[{}]", response);
        logger.info("ServletAPIController test session[{}]", session);
        logger.info("ServletAPIController test webRequest[{}]", webRequest);
        request.getLocale();
        request.getUserPrincipal();
        //request:http://localhost:8080/servletAPI/test.htm
        //HttpServletResponse 响应时 returnValue set void
    }
}
