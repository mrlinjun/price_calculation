package org.interview;

import org.interview.calculate.AbstractPriceCalService;
import org.interview.exception.NoException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class PriceCalService {

    private final static Map<Integer, AbstractPriceCalService> ref = new HashMap<>();

    public static void register(Integer no, AbstractPriceCalService priceCalService) {
        ref.put(no, priceCalService);
    }

    private static AbstractPriceCalService router(Integer no) {
        if (!ref.containsKey(no)){
            throw new NoException(no, String.format("输入题号：%s 有误，目前只支持%s", no, ref.keySet()));
        }
        return ref.get(no);
    }

    public static BigDecimal calculate(Integer no, String... weights) {
        AbstractPriceCalService priceCalService = router(no);
        return priceCalService.calculatePrice(weights);
    }

    public static void main(String[] args) {
        System.out.println(calculate(4, "45", "23", "30"));
    }

    static{
        SubPriceCalInitializer.initializer();
    }

}
