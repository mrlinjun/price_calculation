package org.interview.exception;

/**
 * 自定义异常，当输入题号有误时，返回一个错误提示
 */
public class NoException extends RuntimeException {

    private int no;

    public NoException(int no, String message) {
        super(message);
        this.no = no;
    }

    public int getInputWeight() {
        return no;
    }

}
