package com.example.lijie.testConcurrent.testLockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * ﻿JDK 中的 rt.jar 里面的 LockSupport 是个工具类，主要作用是挂起和唤醒线程，它是创建锁和其它同步类的基础。
 * ﻿LockSupport 类与每个使用它的线程都会关联一个许可证,默认调用LockSupport 类的方法的线程是不持有许可证的，
 * LockSupport 内部使用 Unsafe 类实现
 *
 * auther lijie  2018/8/10.
 */
public class TestLockSupportOne {

    public static void main1(String[] args) {
        System.out.println("begin park!");

        //﻿void park() 方法 如果调用 park() 的线程已经拿到了与 LockSupport 关联的许可证，
        // 则调用 LockSupport.park() 会马上返回，
        // 否者调用线程会被禁止参与线程的调度，也就是会被阻塞挂起。
        LockSupport.park();
        System.out.println("end park!");
    }

    public static void main(String[] args) {
        System.out.println("begin park!");


        /*void unpark(Thread thread) 方法 当一个线程调用了 unpark 时候，
        如果参数 thread 线程没有持有 thread 与 LockSupport 类关联的许可证，则让 thread 线程持有。
        如果 thread 之前调用了 park() 被挂起，则调用 unpark 后，该线程会被唤醒。
        如果 thread 之前没有调用 park，则调用 unPark 方法后，在调用 park() 方法，会立刻返回*/
        LockSupport.unpark(Thread.currentThread());

        /*﻿void park() 方法 如果调用 park() 的线程已经拿到了与 LockSupport 关联的许可证，
         则调用 LockSupport.park() 会马上返回，
         否者调用线程会被禁止参与线程的调度，也就是会被阻塞挂起。*/
        LockSupport.park();
        System.out.println("end park!");
    }

}