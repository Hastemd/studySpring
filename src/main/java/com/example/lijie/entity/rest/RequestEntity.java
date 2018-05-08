package com.example.lijie.entity.rest;

import javax.validation.Valid;

public class RequestEntity<T> {
    @Valid
    private T params;           // 业务参数
    private String timestamp;   // 时间戳
    private String digest;      // 签名摘要
    private String code;        // 客户端标识

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
