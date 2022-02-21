package org.interview;

import org.interview.calculate.AbstractPriceCalService;

import java.io.File;

/**
 * 初始化初始化所有价格计算器的子类，让所有子类自行注册到映射
 *
 * @see AbstractPriceCalService
 */
public class SubPriceCalInitializer {

    private final static String PACKAGE_NAME = "org.interview.calculate.impl";

    private final static File ROOT = new File(System.getProperty("user.dir") + "\\src\\main\\java\\org\\interview\\calculate\\impl");

    /**
     * 加载
     *
     * @throws Exception
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
