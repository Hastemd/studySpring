package basic.testThread.testConcurrent.testThreadLocal;

/**
 * ﻿同一个 ThreadLocal 变量在父线程中设置值后，在子线程中是获取不到的
 * auther lijie  2018/8/4.
 */
public class TestThreadLocalNoInheritable {

    //public static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<String>();


    public static void main(String[] args) {
        threadLocal.set("hello world");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread: " + threadLocal.get());
            }
        });

        thread.start();

        System.out.println("main: " + threadLocal.get());
    }
}