/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-11-21 15:14 创建
 *
 */
package web.requestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.BaseController;

/**
 * @author jxilong@yiji.com
 */

@RequestMapping("pathVariable")
@Controller
public class PathVariableController extends BaseController {

    @RequestMapping("{userId}")
    public void test(@PathVariable String userId, @PathVariable("userId") String tt) {
        logger.info("PathVariableController test userId[{}],tt[{}]", userId, tt);
        //request:http://localhost:8080/pathVariable/121212.htm
        //returnValue is null    applyDefaultViewName(request, mv);
    }
}
