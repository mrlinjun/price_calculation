package org.interview;

import org.interview.calculate.impl.FirstPriceCalService;
import org.interview.exception.WeightFormatException;
import org.interview.exception.WeightNumException;
import org.interview.params.PriceConst;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 *
 */
public class FirstCalculationTest {

    private FirstPriceCalService priceCalService = FirstPriceCalService.getInstance();

    /**
     * 输入错误的斤数入参个数，按期望抛出WeightNumException异常
     */
    @Test(expected = WeightNumException.class)
    public void testNo1WrongWeightNum(){
        priceCalService.calculatePrice("2");
    }

    /**
     * 输入错误的斤数入参格式，斤数带了非法的小数点，按期望抛出WeightFormatException异常
     */
    @Test(expected = WeightFormatException.class)
    public void testNo1WrongWeightFormat1(){
        priceCalService.calculatePrice("2.2", "3");
    }

    /**
     * 输入错误的斤数入参格式，斤数带了非法的负数，按期望抛出WeightFormatException异常
     */
    @Test(expected = WeightFormatException.class)
    public void testNo1WrongWeightFormat2(){
        priceCalService.calculatePrice("-2", "3");
    }

    /**
     * 对第一题进行测试，校验计算结果是否正确
     */
    @Test
    public void testNo1() {
        // 苹果10斤，草莓20斤
        String appleWeight = "10";
        String strawberryWeight = "20";
        BigDecimal result = priceCalService.calculatePrice(appleWeight, strawberryWeight);
        System.out.printf("第一题：%s%n", result);
        // 计算水果总价
        BigDecimal verify = BigDecimal.valueOf(PriceConst.APPLE_PRICE).
                multiply(new BigDecimal(appleWeight)).
                add(BigDecimal.valueOf(PriceConst.STRAWBERRY_PRICE).
                        multiply(new BigDecimal(strawberryWeight)));
        Assert.assertEquals(result, verify);
    }




}