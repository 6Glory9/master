/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-11-21 17:34 创建
 *
 */
package web.model;

import form.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import web.BaseController;

/**
 * @author jxilong@yiji.com
 */
@Controller
@RequestMapping("modelMap")
public class ModelMapController extends BaseController {

    @ModelAttribute("tt")
    public User getUser() {
        User user = new User();
        user.setPassword("glory");
        return user;
    }

    @RequestMapping("test")
    public String test(ModelMap map) {
        //MapMethodProcessor  mavContainer.getModel();

        map.put("ttt", "ttt");
        //request:http://localhost:8080/modelMap/test.htm?userName=glory
        //ModeMap,Map  是上下文 隐含模型
        return "success";
    }
}
