/**
 * Created by lijie on 2017/9/22.
 */
package com.example.lijie.testSpring.spring.test.aop;

import org.junit.Test;
import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * auther lijie  2017/9/22.
 */
public class NaiveWaiter implements Waiter{


    @Override
    public void greetTo(String name) {
        System.out.println("greet to " + name + " ...");
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serving to " + name + " ...");
    }

    @Test
    public void before(){
        Waiter target = new NaiveWaiter();
        BeforeAdvice advice = new GreetingBeforeAdvice();
        //Spring提供的代理工厂
        ProxyFactory pf = new ProxyFactory();
        //设置代理目标
        pf.setTarget(target);
        //为代理目标添加增强
        pf.addAdvice(advice);

        //生成代理实例
        Waiter proxy = (Waiter) pf.getProxy();
        proxy.greetTo("李杰");
        proxy.serveTo("lijie");
    }
}

interface Waiter{
    void greetTo(String name);
    void serveTo(String name);
}

class GreetingBeforeAdvice implements MethodBeforeAdvice{

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String clientName = (String) objects[0];
        System.out.println("你好! " + clientName);
    }
}