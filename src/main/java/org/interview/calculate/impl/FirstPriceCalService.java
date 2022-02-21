package org.interview.calculate.impl;

import org.interview.Calculation;
import org.interview.calculate.AbstractPriceCalService;
import org.interview.exception.WeightNumException;
import org.interview.params.PriceConst;

import java.math.BigDecimal;

/**
 * 题目一计算类
 */
public class FirstPriceCalService extends AbstractPriceCalService {

    /**
     * 面试题一：若干斤苹果和草莓，需要计算一共多少钱？水果斤数为大于等于 0 的整数,无论数值为多少，均需验证程序计算结果的正确性
     * 解题思路：因为题目有要求可以输入任意大于等于0的整数，因此无法使用int、long等基本类型，这里经考虑，使用string类型作为入参类型
     *
     * @param weights 水果重量 【0】苹果 【1】草莓
     * @return 返回BigDecimal类型的商品总价
     */
    public BigDecimal calculate(String... weights) {
        checkWeightNum(weights);
        return new BigDecimal(weights[0]).multiply(BigDecimal.valueOf(PriceConst.APPLE_PRICE))
                .add(new BigDecimal(weights[1]).multiply(BigDecimal.valueOf(PriceConst.STRAWBERRY_PRICE)));
    }

    /**
     * 校验入参数量，是否多输入或者少输入
     *
     * @param weights 水果的斤数
     */
    protected void checkWeightNum(String... weights) throws WeightNumException {
        if (!(weights != null && weights.length == 2)) {
            int num = weights == null ? 0 : weights.length;
            throw new WeightNumException(num, String.format("输入的斤数入参为%s个，不符合题目要求，本题需要输入2个斤数参数，第一为苹果的斤数，第二为草莓的斤数。", num));
        }
    }

    static {
        Calculation.register(1, getInstance());
    }

    public static FirstPriceCalService getInstance() {
        if (instance == null) {
            synchronized (FirstPriceCalService.class) {
                if (instance == null) {
                    instance = new FirstPriceCalService();
                }
            }
        }
        return instance;
    }

    private volatile static FirstPriceCalService instance = null;

    private FirstPriceCalService() {}

}
