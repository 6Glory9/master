/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-26 22:07 创建
 *
 */
package helloworld.helloworld;

import com.yjf.common.lang.enums.GenderEnum;
import helloworld.AbstractSpringDataJPABaseTest;
import jpa.entities.basic.BasicType;
import org.junit.Test;

/**
 * @author jxilong@yiji.com
 */
public class BasicTypeTest extends AbstractSpringDataJPABaseTest {

    @Test
    public void testSave() {
        BasicType basicType = new BasicType();
        basicType.setGender(GenderEnum.FEMALE);
        basicType.setRealName("jiangxilong");
        basicType.setUserName("glory");
        basicTypeRepository.save(basicType);
    }
}
