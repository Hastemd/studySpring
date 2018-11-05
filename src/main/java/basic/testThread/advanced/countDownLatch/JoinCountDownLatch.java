package basic.testThread.advanced.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * ﻿日常开发中经常会遇到需要在主线程中开启多线程去并行执行任务，
 * 并且主线程需要等待所有子线程执行完毕后在进行汇总的场景，
 * 在 CountDownLatch 出现之前一般都是使用线程的 join() 方法来实现，
 * 但是 join 不够灵活，不能够满足不同场景的需要，
 * 下面看一个使用 CountDownLatch 的例子
 * auther lijie  2018/11/5.
 */
public class JoinCountDownLatch {

    //创建一个CountDownLatch实例
    private static volatile CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadOne over!");
                countDownLatch.countDown();
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("threadTwo over!");
                countDownLatch.countDown();
            }
        });

        threadOne.start();
        threadTwo.start();
        System.out.println("wait all child thread over!");

        countDownLatch.await();

        System.out.println("all child thread over!");
    }

}