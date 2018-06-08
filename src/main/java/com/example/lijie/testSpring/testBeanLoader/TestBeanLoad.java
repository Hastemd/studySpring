package com.example.lijie.testSpring.testBeanLoader;

import com.example.lijie.config.ApplicationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * auther lijie  2018/6/4.
 */
public class TestBeanLoad {

    /**
     * @Description 跟代码,看下bean的初始化
     * @Author 李杰 lijie@ane56.com
     * @Date 2018/6/4 下午10:20
     */

    public static void main(String[] args) {
        //ApplicationConfig 只加载了service
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    }
}