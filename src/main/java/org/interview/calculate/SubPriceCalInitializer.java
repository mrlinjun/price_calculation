package org.interview.calculate;

import java.io.File;

/**
 * 初始化初始化所有价格计算器的子类，让所有子类自行注册到映射
 *
 * @see AbstractPriceCalService
 */
public class SubPriceCalInitializer {

    /**
     * 包名
     */
    private final static String PACKAGE_NAME = "org.interview.calculate.impl";

    /**
     * 此路径下的所有类都会被加载
     */
    private final static File ROOT = new File(System.getProperty("user.dir") + File.separator +
            "src" + File.separator +
            "main" + File.separator +
            "java" + File.separator +
            "org" + File.separator +
            "interview" + File.separator +
            "calculate" + File.separator +
            "impl");

    /**
     * 加载指定包下的计算子类，并触发子类的静态代码块，让子类将题号的自己的映射关系进行注册
     */
    public static void initializer() {
        File[] files = ROOT.listFiles();
        for (int fileIndex = 0; fileIndex < files.length; fileIndex++) {
            File file = files[fileIndex];
            String name = file.getName().substring(0, file.getName().length() - 5);
            try {
                Class.forName(PACKAGE_NAME + "." + name);
            } catch (ClassNotFoundException e) {
                System.out.println(String.format("类加载失败，没有找到类%s", PACKAGE_NAME + name));
            }
        }
    }

}
