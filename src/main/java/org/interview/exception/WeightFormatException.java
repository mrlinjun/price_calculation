package org.interview.exception;

/**
 * 自定义异常，当输入斤数格式有误时，返回自定义的错误提示
 */
public class WeightFormatException extends RuntimeException {

    private String inputWeight;

    public WeightFormatException(String inputWeight, String message) {
        super(message);
        this.inputWeight = inputWeight;
    }

    public String getInputWeight() {
        return inputWeight;
    }

}
