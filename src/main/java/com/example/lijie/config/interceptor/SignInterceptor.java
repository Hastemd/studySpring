package com.example.lijie.config.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.TypeReference;
import com.example.lijie.config.filter.BodyReaderRequestWrapper;
import com.example.lijie.entity.rest.RequestEntity;
import com.example.lijie.entity.rest.Signature;
import com.example.lijie.exception.APIException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignInterceptor extends HandlerInterceptorAdapter {
    private Logger logger = LoggerFactory.getLogger(SignInterceptor.class);
    private final Pattern paramsRegex = Pattern.compile("(\"params\"\\s*:\\s*)((?<!\\\\)\".*?(?<!\\\\)\")");
    private final Map<String, String> keySecret = new HashMap<>();

    public SignInterceptor() {
        keySecret.put("OPC", "M7QyDsvJbU");
        keySecret.put("TL", "TLQyCasJb3");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(request instanceof BodyReaderRequestWrapper)) {
            throw new APIException("无法从RequestBody中获取参数");
        }

        BodyReaderRequestWrapper requestWrapper = (BodyReaderRequestWrapper) request;
        String body = requestWrapper.getBodyString();
        logger.debug("接口：{}，参数：{}", request.getRequestURI(), body);

        if (StringUtils.isBlank(body)) {
            throw new APIException("请求参数不能为空");
        }

        RequestEntity<String> requestEntity;
        try {
            requestEntity = JSON.parseObject(body, new TypeReference<RequestEntity<String>>() {});
        } catch (JSONException e) {
            throw new APIException("请求参数不是JSON格式");
        }

        String timestamp = requestEntity.getTimestamp();
        if (StringUtils.isBlank(timestamp)) {
            throw new APIException("时间戳不能为空");
        }

        String digest = requestEntity.getDigest();
        if (StringUtils.isBlank(digest)) {
            throw new APIException("签名数据不能为空");
        }

        String params = requestEntity.getParams();
        if (StringUtils.isBlank(params)) {
            throw new APIException("参数不能为空");
        }

        String key = requestEntity.getCode();
        if (StringUtils.isBlank(key)) {
            throw new APIException("客户ID不能为空");
        }

        String secret = this.getSecret(key);
        if (StringUtils.isBlank(secret)) {
            throw new APIException("非法的客户ID");
        }

        String expectedDigest = Signature.digest(params, key, secret);
        if (!digest.equals(expectedDigest)) {
            throw new APIException("签名数据不正确");
        }

        // 替换掉请求参数params中的反斜杠
        Matcher matcher = paramsRegex.matcher(body);
        if (matcher.find()) {
            String sourceParams = matcher.group(2); // 包含反斜杠的参数内容："params":"这里的内容(包括两边的引号)"
//            String newParams = StringUtils.replace(sourceParams, "\\\"", "\"");
//            newParams = StringUtils.replaceChars(newParams, "\\", "");
//            newParams = StringUtils.replace(newParams, "\"{", "{");
//            newParams = StringUtils.replace(newParams, "}\"", "}");
//            newParams = StringUtils.replace(newParams, "\"[", "[");
//            newParams = StringUtils.replace(newParams, "]\"", "]");
            String newBody = StringUtils.replace(body, sourceParams, params);
            requestWrapper.setBody(newBody);
        }

        return true;
    }

    private String getSecret(String key) {
        return keySecret.get(key);
    }
}
