package basic.testThread;

/**
 * ﻿当一个线程调用共享对象的 wait() 方法被阻塞挂起后，
 * 如果其它线程中断了该线程，
 * 则该线程会抛出 InterruptedException 异常后返回
 * auther lijie  2018/11/1.
 */
public class WaitNotifyInterupt {

    static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println("---begin---");
                    try {
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("---end---");
                }
            }
        });

        threadA.start();
        Thread.sleep(2000);

        System.out.println("---begin interrupt threadA---");
        Thread.sleep(1000);

        threadA.interrupt();
        System.out.println("---end interrupt threadA---");

    }
}