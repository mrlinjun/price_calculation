package org.interview;

import org.interview.calculate.AbstractPriceCalService;
import org.interview.calculate.SubPriceCalInitializer;
import org.interview.exception.NoException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 计算器，作为所有计算需求的统一入口，由此分发给具体的计算子类
 */
public class CalculationHandler {

    /**
     * 维持题号和计算子类的映射关系
     */
    private final static Map<Integer, AbstractPriceCalService> ref = new HashMap<>();

    /**
     * 给定题号和斤数，能够计算出水果总价
     *
     * @param no      题号
     * @param weights 水果斤数
     * @return 水果总价
     */
    public static BigDecimal calculate(Integer no, String... weights) {
        AbstractPriceCalService priceCalService = router(no);
        return priceCalService.calculatePrice(weights);
    }

    public static void main(String[] args) {
        System.out.println(calculate(4, "45", "23", "30"));
    }


    /**
     * 提供给子类调用，子类加载时自动把自己和题号的映射关系在此处进行注册
     *
     * @param no 题号
     * @param priceCalService 计算子类
     */
    public static void register(Integer no, AbstractPriceCalService priceCalService) {
        ref.put(no, priceCalService);
    }

    /**
     * 路由器，给定题号能够得到对应的计算子类
     *
     * @param no 题号
     * @return 返回计算子类的实例
     */
    private static AbstractPriceCalService router(Integer no) {
        if (!ref.containsKey(no)) {
            throw new NoException(no, String.format("输入题号：%s 有误，目前只支持%s", no, ref.keySet()));
        }
        return ref.get(no);
    }

    /**
     * 此处触发一个初始化逻辑，使用初始化器，将子类加载并生成题号和子类的映射关系
     */
    static {
        SubPriceCalInitializer.initializer();
    }

}
