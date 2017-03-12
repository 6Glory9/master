/*
 * www.yiji.com Inc.
 * Copyright (c) 2014 All Rights Reserved
 */

/*
 * 修订记录:
 * jxilong@yiji.com 2015-12-03 20:38 创建
 *
 */
package utils;

import com.yjf.common.util.StringUtils;
import enums.ExceptionEnum;
import enums.PaymentModelEnum;
import exeptions.BusinessException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jxilong@yiji.com
 */
public abstract class PaymentModelUtil {

    private static int ABILITY_COUNT = 6;
    private static String ABILITY_FLAT = "1";

    public static void hasAbility(PaymentModelEnum checkPaymentModel, String paymentModel) {
        List<String> ownAbilities = StringUtils.stringSplitToList(paymentModel, "\\d");
        if (ownAbilities.size() != ABILITY_COUNT) {
            throw new BusinessException(ExceptionEnum.ILLEGAL_PAYMENT_MODEL);
        }
        Set<PaymentModelEnum> ownAbilitiesModel = new HashSet<>();

        for (int i = 0; i < ownAbilities.size(); i++) {
            String abilitity = ownAbilities.get(i);
            if (abilitity.equals(ABILITY_FLAT)) {
                ownAbilitiesModel.add(PaymentModelEnum.getByCode(String.valueOf(i)));
            }
        }

        if (ownAbilitiesModel.contains(checkPaymentModel)) {
            return;
        }

        throw new BusinessException(ExceptionEnum.NO_OWN_ABILITY);

    }

}
