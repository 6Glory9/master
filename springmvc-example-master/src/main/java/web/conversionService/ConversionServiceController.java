/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-11-21 18:03 创建
 *
 */
package web.conversionService;

import form.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.BaseController;

/**
 * @author jxilong@yiji.com
 */
@Controller
@RequestMapping("conversionService")
public class ConversionServiceController extends BaseController {

    @RequestMapping("test")
    public void test(@RequestParam("userInfo") User user) {
        logger.info("ConversionServiceController test User[{}]",user);
        //request:http://localhost:8080/conversionService/test.htm?userInfo=glory:glory

        //@InitBinder local
        //webBindingInitializer
    }
}
