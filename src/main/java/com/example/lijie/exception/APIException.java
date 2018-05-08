package com.example.lijie.exception;

/**
 * @Description 外部系统访问异常
 * @Author 李杰 lijie@ane56.com
 * @Date 2018/5/8 下午5:55
 */
public class APIException extends RuntimeException {
    public APIException() {
        super();
    }

    public APIException(String s) {
        super(s);
    }
}