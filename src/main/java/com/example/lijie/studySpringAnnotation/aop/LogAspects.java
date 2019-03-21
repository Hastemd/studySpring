package com.example.lijie.studySpringAnnotation.aop;

/**
 * auther lijie  2019/2/20.
 */
public class LogAspects {

    public void logStart(){
        System.out.println("除法运行...参数列表是: {}");
    }

    public void logEnd(){
        System.out.println("除法结束...");
    }

    public void logReturn(){
        System.out.println("除法正常返回...运行结果是: {}");
    }

    public void logException(){
        System.out.println("除法异常返回...异常信息: {}");
    }
}