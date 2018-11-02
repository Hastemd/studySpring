package basic.testThread.advanced;

import java.util.concurrent.locks.LockSupport;

/**
 * 1:
 * ﻿void park() 方法 如果调用 park() 的线程已经拿到了与 LockSupport 关联的许可证，
 * 则调用 LockSupport.park() 会马上返回，否者调用线程会被禁止参与线程的调度，也就是会被阻塞挂起
 *
 * 2:﻿
 * void unpark(Thread thread) 方法 当一个线程调用了 unpark 时候，
 * 如果参数 thread 线程没有持有 thread 与 LockSupport 类关联的许可证，
 * 则让 thread 线程持有。如果 thread 之前调用了 park() 被挂起，
 * 则调用 unpark 后，该线程会被唤醒。如果 thread 之前没有调用 park，
 * 则调用 unPark 方法后，在调用 park() 方法，会立刻返回
 *
 * auther lijie  2018/11/2.
 */
public class TestLockSupport {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("begin park");

        //这里park(),直接主线程暂停了,都不去创建子线程了呢~
        //LockSupport.park();

        final Thread thread = Thread.currentThread();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("开始睡");
                    Thread.sleep(100000);
                    System.out.println("睡醒了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("yao unpark 了");
                LockSupport.unpark(thread);

            }
        }).start();
        LockSupport.park();

        //LockSupport.unpark(Thread.currentThread());

        System.out.println("end park");
    }
}