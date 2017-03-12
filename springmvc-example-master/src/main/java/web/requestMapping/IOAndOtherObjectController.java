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
import web.BaseController;

import java.io.OutputStream;

/**
 * @author jxilong@yiji.com
 */
@RequestMapping("IOAndOtherObject")
@Controller
public class IOAndOtherObjectController extends BaseController {

    @RequestMapping("test")
    public void test(OutputStream outputStream) {
        logger.info("IOAndOtherObjectController test outputStream[{}]", outputStream);
        //request:http://localhost:8080/IOAndOtherObject/test.htm
    }
}
