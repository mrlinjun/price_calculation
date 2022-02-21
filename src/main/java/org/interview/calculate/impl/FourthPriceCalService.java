package org.interview.calculate.impl;

import org.interview.CalculationHandler;
import org.interview.exception.WeightFormatException;

import java.math.BigDecimal;

/**
 * 题目四计算类
 */
public class FourthPriceCalService extends ThirdPriceCalService {

    /**
     * 面试题四：促销活动效果明显，超市继续加大促销力度，购物满 100 减 10 块。若干斤苹果、 草莓和芒果，需计算一共需要多少钱？水果斤数为大于等于 0 的整数,无论数值为多少，均需验证程序计算结果的正确性
     * 解题思路：因为是加大促销力度，所以是在草莓打8折的情况下折上折。
     *
     * @param weights 水果重量  【0】苹果 【1】草莓 【2】芒果
     * @return
     * @throws WeightFormatException
     */
    public BigDecimal calculate(String... weights) {
        super.checkWeightNum(weights);
        BigDecimal result = super.calculate(weights);
        if (result.compareTo(new BigDecimal("100")) >= 0) {
            result = result.subtract(new BigDecimal("10"));
        }
        return result;
    }

    static{
        CalculationHandler.register(4, new FourthPriceCalService());
    }

}
