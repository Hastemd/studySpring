/**
 * Created by lijie on 2017/9/21.
 */
package com.example.lijie.testSpring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * auther lijie  2017/9/21.
 */
public class PerformanceHandler implements InvocationHandler{
    private Object target;


    public PerformanceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName()+"."+method.getName());
        Object invoke = method.invoke(target, args);
        PerformanceMonitor.end();
        return invoke;
    }



}