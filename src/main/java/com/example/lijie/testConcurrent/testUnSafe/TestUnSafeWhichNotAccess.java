package com.example.lijie.testConcurrent.testUnSafe;

import sun.misc.Unsafe;

/**
 * 练习使用Unsafe类
 * auther lijie  2018/8/10.
 */

/**
 * @Description ﻿我们知道 Unsafe 类是在 rt.jar 里面提供的，
 * 而 rt.jar 里面的类是使用 Bootstrap 类加载器加载的，而我们启动 main 函数所在的类是使用 AppClassLoader 加载的，
 * 所以在 main 函数里面加载 Unsafe 类时候鉴于委托机制会委托给 Bootstrap 去加载 Unsafe 类。
 *
 *
 * 如果没有代码（2.2.8）这鉴权，那么我们应用程序就可以随意使用 Unsafe 做事情了，
 * 而 Unsafe 类可以直接操作内存，是不安全的，所以 JDK 开发组特意做了这个限制，
 * 不让开发人员在正规渠道下使用 Unsafe 类，而是在 rt.jar 里面的核心类里面使用 Unsafe 功能。
 * @Author 李杰 lijie@ane56.com
 * @Date 2018/8/10 上午10:54
 */
public class TestUnSafeWhichNotAccess {

    static final Unsafe UNSAFE = Unsafe.getUnsafe();

    static final long stateOffset;

    private volatile long state = 0;

    static {
        try {
            stateOffset = UNSAFE.objectFieldOffset(TestUnSafeWhichNotAccess.class.getDeclaredField("state"));
        } catch (NoSuchFieldException e) {
            System.out.println(e.getLocalizedMessage());
            throw new Error(e);
        }
    }

    public static void main(String[] args) {
        TestUnSafeWhichNotAccess test = new TestUnSafeWhichNotAccess();

        boolean success = UNSAFE.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(success);
    }

}