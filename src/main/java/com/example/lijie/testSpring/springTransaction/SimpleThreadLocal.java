/**
 * Created by lijie on 2017/10/13.
 */
package com.example.lijie.testSpring.springTransaction;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * auther lijie  2017/10/13.
 * ThreadLocal 的简单实现
 */
public class SimpleThreadLocal {
    private Map valueMap = Collections.synchronizedMap(new HashMap());

    public void set(Object newValue){
        valueMap.put(Thread.currentThread(),newValue);
    }

    public Object get(){
        Thread currentThread = Thread.currentThread();
        Object obj = valueMap.get(currentThread);
        if(obj == null && !valueMap.containsKey(currentThread)){
            obj = initialValue();
            valueMap.put(currentThread,obj);
        }
        return obj;
    }

    private Object initialValue() {
        return null;
    }

    public void remove(){
        valueMap.remove(Thread.currentThread());
    }
}