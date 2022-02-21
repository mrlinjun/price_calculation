package org.interview;

import org.interview.exception.NoException;
import org.interview.exception.WeightFormatException;
import org.interview.exception.WeightNumException;
import org.interview.params.PriceConst;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class CalculationTest {

    /**
     * 输入错误的题号，按期望抛出NoException异常
     */
    @Test(expected = NoException.class)
    public void testWrongNo() {
        Calculation.calculate(7, "2", "4");
    }

    /**
     * 输入错误的斤数入参个数，按期望抛出WeightNumException异常
     */
    @Test(expected = WeightNumException.class)
    public void testWrongWeightNum() {
        Calculation.calculate(1, "2");
    }

    /**
     * 输入错误的斤数入参格式，斤数带了非法的小数点，按期望抛出WeightFormatException异常
     */
    @Test(expected = WeightFormatException.class)
    public void testWrongWeightFormat1() {
        Calculation.calculate(1, "2.2", "3.4");
    }

    /**
     * 输入错误的斤数入参格式，斤数带了非法的负数，按期望抛出WeightFormatException异常
     */
    @Test(expected = WeightFormatException.class)
    public void testWrongWeightFormat2() {
        Calculation.calculate(1, "-6", "3");
    }

    /**
     * 对第一题进行测试，校验计算结果是否正确
     */
    @Test
    public void testNo1() {
        // 苹果10斤，草莓20斤
        String appleWeight = "10";
        String strawberryWeight = "20";
        BigDecimal result = Calculation.calculate(1, appleWeight, strawberryWeight);
        System.out.printf("第一题：%s%n", result);
        // 计算水果总价
        BigDecimal verify = BigDecimal.valueOf(PriceConst.APPLE_PRICE).
                multiply(new BigDecimal(appleWeight)).
                add(BigDecimal.valueOf(PriceConst.STRAWBERRY_PRICE).
                        multiply(new BigDecimal(strawberryWeight)));
        Assert.assertEquals(result, verify);
    }

    /**
     * 对第二题进行测试，校验计算结果是否正确
     */
    @Test
    public void testNo2() {
        // 苹果10斤，草莓20斤，芒果30斤
        String appleWeight = "10";
        String strawberryWeight = "20";
        String mongoWeight = "30";
        BigDecimal result = Calculation.calculate(2, appleWeight, strawberryWeight, mongoWeight);
        System.out.printf("第二题：%s%n", result);
        // 计算水果总价
        BigDecimal verify = BigDecimal.valueOf(PriceConst.APPLE_PRICE).multiply(new BigDecimal(appleWeight)).
                add(BigDecimal.valueOf(PriceConst.STRAWBERRY_PRICE).multiply(new BigDecimal(strawberryWeight))).
                add(BigDecimal.valueOf(PriceConst.MANGO_PRICE).multiply(new BigDecimal(mongoWeight)));
        Assert.assertEquals(result, verify);
    }

    /**
     * 对第三题进行测试，校验计算结果是否正确
     */
    @Test
    public void testNo3() {
        // 苹果10斤，草莓20斤，芒果30斤
        String appleWeight = "10";
        String strawberryWeight = "20";
        String mongoWeight = "30";
        BigDecimal result = Calculation.calculate(3, appleWeight, strawberryWeight, mongoWeight);
        System.out.printf("第三题：%s%n", result);
        // 计算水果总价
        BigDecimal verify = BigDecimal.valueOf(PriceConst.APPLE_PRICE).multiply(new BigDecimal(appleWeight)).
                add(BigDecimal.valueOf(PriceConst.STRAWBERRY_PRICE).multiply(new BigDecimal(strawberryWeight)).multiply(new BigDecimal("0.8"))).
                add(BigDecimal.valueOf(PriceConst.MANGO_PRICE).multiply(new BigDecimal(mongoWeight)));
        Assert.assertEquals(result, verify);
    }

    /**
     * 对第四题进行测试，校验计算结果是否正确
     */
    @Test
    public void testNo4() {
        // 苹果10斤，草莓20斤，芒果30斤
        String appleWeight = "10";
        String strawberryWeight = "20";
        String mongoWeight = "30";
        BigDecimal result = Calculation.calculate(4, appleWeight, strawberryWeight, mongoWeight);
        System.out.printf("第四题：%s%n", result);
        // 计算水果总价
        BigDecimal verify = BigDecimal.valueOf(PriceConst.APPLE_PRICE).multiply(new BigDecimal(appleWeight)).
                add(BigDecimal.valueOf(PriceConst.STRAWBERRY_PRICE).multiply(new BigDecimal(strawberryWeight)).multiply(new BigDecimal("0.8"))).
                add(BigDecimal.valueOf(PriceConst.MANGO_PRICE).multiply(new BigDecimal(mongoWeight)));
        if (verify.compareTo(BigDecimal.valueOf(100)) >= 0){
            verify = verify.subtract(BigDecimal.valueOf(10));
        }
        Assert.assertEquals(result, verify);
    }

}