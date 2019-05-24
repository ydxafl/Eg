package com.zhchenai.eg.net;

/**
 * 类描述：Api异常封装
 */
public class ApiException {

    private int statuCode;

    private String message;

    public ApiException(int statuCode, String message) {
        this.statuCode = statuCode;
        this.message = message;
    }

    public int getStatuCode() {
        return statuCode;
    }

    public void setStatuCode(int statuCode) {
        this.statuCode = statuCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
