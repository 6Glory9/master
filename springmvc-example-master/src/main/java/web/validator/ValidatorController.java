/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-11-22 12:10 创建
 *
 */
package web.validator;

import form.UserValid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import web.BaseController;

import javax.validation.Valid;

/**
 * @author jxilong@yiji.com
 */
@Controller
@RequestMapping("valid")
public class ValidatorController extends BaseController {

    @RequestMapping("test")
    public void test(@Valid UserValid userValid, BindingResult errorResult) {
        logger.info("ValidatorController test[{}]", userValid);
        if (errorResult.hasErrors()) {
            StringBuilder errorDesc = new StringBuilder();
            errorDesc.append(userValid.getClass().getName()).append("【");
            for (ObjectError objectError : errorResult.getAllErrors()) {
                FieldError fieldError = (FieldError) objectError;
                errorDesc.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append(",");
            }
            errorDesc.deleteCharAt(errorDesc.length() - 1).append("】");
            logger.warn("error desc  {}",errorDesc.toString());
        }

    }

}
