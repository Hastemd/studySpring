package com.example.lijie.studySpringAnnotation.config;

/**
 * auther lijie  2019/2/20.
 */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * @Description 这个方法要干什么
 * @Author 李杰 lijie@ane56.com
 * @Date 2019/2/20 10:25 AM
 *
 *  BeanPostProcessor : bean的后置处理器, 在bean初始化前后进行后置处理
 */
@Configuration
@ComponentScan(value="com.example.lijie.studySpringAnnotation")
public class MainconfigOfLifeCycle {


}