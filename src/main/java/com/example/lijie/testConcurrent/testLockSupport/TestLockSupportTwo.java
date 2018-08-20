package com.example.lijie.testConcurrent.testLockSupport;

import java.util.concurrent.locks.LockSupport;

/**
 * ﻿首先创建了一个子线程 thread，启动后子线程调用 park 方法，由于默认子线程没有持有许可证，会把自己挂起。
 * 主线程休眠 1s 为的是主线程在调用 unpark 方法前让子线程输出 child thread begin park! 并阻塞。
 * 主线程然后执行 unpark 方法，参数为子线程，目的是让子线程持有许可证，然后子线程调用的 park 方法就返回了。
 * park 方法返回时候不会告诉你是因为何种原因返回，所以调用者需要根据之前是处于什么目前调用的 park 方法，再次检查条件是否满足，如果不满足的话还需要再次调用 park 方法。
 * 例如，线程在返回时的中断状态，根据调用前后中断状态对比就可以判断是不是因为被中断才返回的。
 *
 * 为了说明调用 park 方法后的线程被中断后会返回，修改上面例子代码，删除 LockSupport.unpark(thread);
 * 然后添加 thread.interrupt(); 代码 TestLockSupportTwo_2
 * auther lijie  2018/8/10.
 */
public class TestLockSupportTwo {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {

                System.out.println("child thread begin park!");

                // 调用park方法，挂起自己
                LockSupport.park();

                System.out.println("child thread unpark!");

            }
        });

        //启动子线程
        thread.start();

        //主线程休眠1S
        Thread.sleep(1000);

        System.out.println("main thread begin unpark!");

        //调用unpark让thread线程持有许可证，然后park方法会返回
        LockSupport.unpark(thread);

    }
}