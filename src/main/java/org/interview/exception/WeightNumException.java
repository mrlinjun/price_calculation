package org.interview.exception;

/**
 * 自定义异常，当输入斤数个数有误时，返回一个错误提示
 */
public class WeightNumException extends RuntimeException {

    private int num;

    public WeightNumException(int num, String message) {
        super(message);
        this.num = num;
    }

    public int getInputWeight() {
        return num;
    }

}
