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
import web.BaseController;

/**
 * @author jxilong@yiji.com
 */
@Controller
@RequestMapping("formatService")
public class FormatServiceController extends BaseController {

    /*TypeConverterDelegate
    * doBind()
    * GenericConversionService#find()
    *ConvertiblePair(ClassHierarchySourceClass,ClassHierarchyTargetClass)-->ConvertersForPair
    *ConvertersForPair.match(SourceClass,TargetClass) --->ConvertersForPair
    *
    * ConvertersForPair.add()   addFirst
    *
    *
    * */

    @RequestMapping("test")
    public void test(User user) {
        logger.info("FormatController test User[{}]",user);
        //request:http://localhost:8080/conversionService/test.htm?userInfo=glory:glory

        //@InitBinder local
        //webBindingInitializer
    }
}
