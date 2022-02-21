package org.interview.calculate.impl;

import org.interview.Calculation;
import org.interview.exception.WeightFormatException;
import org.interview.params.PriceConst;

import java.math.BigDecimal;

/**
 * 题目三计算类
 */
public class ThirdPriceCalService extends SecondPriceCalService {

    /**
     * 面试题三：草莓限时打8折，若干斤苹果、 草莓和芒果，需计算一共需要多少钱？水果斤数为大于等于 0 的整数,无论数值为多少，均需验证程序计算结果的正确性
     * 解题思路：因为题目有要求可以输入任意大于等于0的整数，因此无法使用int、long等基本类型，这里经考虑，使用string类型作为入参类型
     *
     * @param weights 水果重量  【0】苹果 【1】草莓 【2】芒果
     * @return 返回BigDecimal类型的商品总价
     * @throws WeightFormatException
     */
    public BigDecimal calculate(String... weights) {
        super.checkWeightNum(weights);
        return new BigDecimal(weights[0]).multiply(BigDecimal.valueOf(PriceConst.APPLE_PRICE))
                .add(new BigDecimal(weights[1]).multiply(BigDecimal.valueOf(PriceConst.STRAWBERRY_PRICE)).multiply(new BigDecimal("0.8")))
                .add(new BigDecimal(weights[2]).multiply(BigDecimal.valueOf(PriceConst.MANGO_PRICE)));
    }

    static{
        Calculation.register(3, new ThirdPriceCalService());
    }

}
