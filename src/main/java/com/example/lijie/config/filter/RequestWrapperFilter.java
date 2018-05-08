package com.example.lijie.config.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 外部系统请求包装过滤器
 * @Author 李杰 lijie@ane56.com
 * @Date 2018/5/8 下午5:30
 */
public class RequestWrapperFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        BodyReaderRequestWrapper requestWrapper = new BodyReaderRequestWrapper(request);
        filterChain.doFilter(requestWrapper, response);
    }


}