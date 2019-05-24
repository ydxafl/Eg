package com.zhchenai.eg.base;

/**
 * Presenter 基类
 */
public interface BasePresenter {

    /**
     * 发生错误
     */
    void onError(String message);


    /**
     * 短消息提示
     * @param message
     */
    void onTips(String message);
}
