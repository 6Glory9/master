/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-11-21 17:24 创建
 *
 */
package web.model;

import form.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import web.BaseController;

/**
 * @author jxilong@yiji.com
 */
@RequestMapping("modelAttribute")
@Controller
public class ModelAttributeController extends BaseController {

    @ModelAttribute("tt")
    public User getUser() {
        User user = new User();
        user.setPassword("glory");
        return user;
    }


    @RequestMapping("test")
    public String test(@ModelAttribute("tt") User user) {
        //ModelAttributeMethodProcessor
        logger.info("ModelAttributeController test user【{}】", user);
        //request.setAttribute()=>request.getAttribute
        return "success";
    }
}
