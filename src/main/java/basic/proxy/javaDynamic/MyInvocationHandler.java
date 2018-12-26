package basic.proxy.javaDynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {

    private Object target;

    public MyInvocationHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //(1)
        System.out.println("-----------------begin "+method.getName()+"-----------------");
        //(2)
        Object result = method.invoke(target, args);
        //(3)
        System.out.println("-----------------end "+method.getName()+"-----------------");
        return result;
    }

    public Object getProxy(){
        //(4)
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
    }

}