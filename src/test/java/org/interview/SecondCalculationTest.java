package org.interview;

import org.interview.calculate.impl.SecondPriceCalService;
import org.interview.exception.WeightFormatException;
import org.interview.exception.WeightNumException;
import org.interview.params.PriceConst;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 *
 */
public class SecondCalculationTest {

    private SecondPriceCalService priceCalService = SecondPriceCalService.getInstance();

    /**
     * 输入错误的斤数入参个数，按期望抛出WeightNumException异常
     */
    @Test(expected = WeightNumException.class)
    public void testNo2WrongWeightNum() {
        priceCalService.calculatePrice("2");
    }

    /**
     * 输入错误的斤数入参格式，斤数带了非法的小数点，按期望抛出WeightFormatException异常
     */
    @Test(expected = WeightFormatException.class)
    public void testNo2WrongWeightFormat1() {
        priceCalService.calculatePrice("2.2", "3");
    }

    /**
     * 输入错误的斤数入参格式，斤数带了非法的负数，按期望抛出WeightFormatException异常
     */
    @Test(expected = WeightFormatException.class)
    public void testNo2WrongWeightFormat2() {
        priceCalService.calculatePrice("-2", "3");
    }

    /**
     * 对第一题进行测试，校验计算结果是否正确
     */
    @Test
    public void testNo2() {
        // 苹果10斤，草莓20斤，芒果30斤
        String appleWeight = "10";
        String strawberryWeight = "20";
        String mongoWeight = "30";
        BigDecimal result = priceCalService.calculatePrice(appleWeight, strawberryWeight, mongoWeight);
        System.out.printf("第二题：%s%n", result);
        // 计算水果总价
        BigDecimal verify = BigDecimal.valueOf(PriceConst.APPLE_PRICE).multiply(new BigDecimal(appleWeight)).
                add(BigDecimal.valueOf(PriceConst.STRAWBERRY_PRICE).multiply(new BigDecimal(strawberryWeight))).
                add(BigDecimal.valueOf(PriceConst.MANGO_PRICE).multiply(new BigDecimal(mongoWeight)));
        Assert.assertEquals(result, verify);
    }

}