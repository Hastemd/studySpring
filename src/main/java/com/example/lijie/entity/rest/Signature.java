package com.example.lijie.entity.rest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Description 参数签名
 * @Author 李杰 lijie@ane56.com
 * @Date 2018/5/8 下午6:03
 */
public class Signature {

    public static String digest(String params, String appKey, String appSecret) {
        String append = params + appKey + appSecret;
        append = DigestUtils.md5Hex(append);
        return Base64.encodeBase64String(append.getBytes());
    }
}