/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-11-21 17:18 创建
 *
 */
package web.model;

import form.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import web.BaseController;

/**
 * @author jxilong@yiji.com
 */
@Controller
@RequestMapping("modelAndViewController")
public class ModelAndViewController extends BaseController {

    @RequestMapping("test")
    public ModelAndView test(User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
