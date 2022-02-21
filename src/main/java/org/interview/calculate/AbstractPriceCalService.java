package org.interview.calculate;

import org.interview.exception.WeightFormatException;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 所有计算类的父类，使用了模板方法模式
 */
public abstract class AbstractPriceCalService {

    /**
     * 正则表达式，能够匹配大于等于0的整数
     */
    private Pattern pattern = Pattern.compile("^[1-9]{1}[\\d]*$");

    /**
     * 校验用户的输入的斤数，如果输入非法，则抛出异常并引导用户输入正确的斤数
     *
     * @param weights 水果斤数
     */
    private void verifyWeight(String... weights) throws WeightFormatException {
        for (String weight : weights) {
            Matcher m = pattern.matcher(weight);
            if (!m.find()) {
                throw new WeightFormatException(weight, String.format("用户输入斤数%s格式有误，请输入大于等于0的整数！", weight));
            }
        }
    }

    /**
     * 各子类需要自行实现计算逻辑
     *
     * @param weights 水果斤数
     * @return 返回总价
     */
    protected abstract BigDecimal calculate(String... weights);

    /**
     * 校验入参数量，是否多输入或者少输入
     *
     * @param weights 水果的斤数
     */
    protected abstract void checkWeightNum(String... weights);

    /**
     * 此处定义了整体的计算流程
     *
     * @param weights 水果斤数
     * @return 水果总价
     */
    public BigDecimal calculatePrice(String... weights) {
        verifyWeight(weights);
        return calculate(weights);
    }

}
