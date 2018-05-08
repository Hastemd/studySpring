/**
 * Created by lijie on 2017/9/21.
 */
package com.example.lijie.testSpring.aop;

/**
 * auther lijie  2017/9/21.
 */
public class MethodPerformance {
    private long begin;
    private long end;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance(){
        end = System.currentTimeMillis();
        long costs = end - begin;
        System.out.println(serviceMethod+"花费"+ costs + "毫秒");
    }
}