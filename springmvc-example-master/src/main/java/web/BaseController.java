/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-11-21 15:15 创建
 *
 */
package web;

import com.yjf.common.service.OrderCheckException;
import form.AjaxResult;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jxilong@yiji.com
 */
public abstract class BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@ResponseBody
	public AjaxResult ajaxRequest(T form, BindingResult errorResult, AjaxProcesor ajaxProcesor) {
		AjaxResult ajaxResult = new AjaxResult();
		try {
			logger.info("request info【{}】", form);
			if (errorResult.hasErrors()) {
				builderValideParam(errorResult);
			}
			ajaxProcesor.processor(form, ajaxResult);

            initSuccesssStatus(ajaxResult);
        } catch (OrderCheckException e) {
            ajaxResult.setStatus("fail");
		} finally {
			logger.info("response param【{}】,result【{}】", form, ajaxResult);
		}
		
		return ajaxResult;
	}

    private void initSuccesssStatus(AjaxResult ajaxResult) {
        ajaxResult.setStatus("success");
    }


    private void builderValideParam(BindingResult errorResult) {
		StringBuilder errorDesc = new StringBuilder();
		errorDesc.append("【");
		for (ObjectError objectError : errorResult.getAllErrors()) {
			FieldError fieldError = (FieldError) objectError;
			errorDesc.append(fieldError.getField()).append(":").append(fieldError.getDefaultMessage()).append(",");
		}
		errorDesc.deleteCharAt(errorDesc.length() - 1).append("】");

        throw new OrderCheckException(null,errorDesc.toString());
    }
}
