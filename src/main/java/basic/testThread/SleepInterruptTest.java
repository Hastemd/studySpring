package basic.testThread;

/**
 * ﻿sleep 方法只是会让调用线程暂时让出指定时间的 CPU 执行权，
 * 但是该线程所拥有的监视器资源，比如锁还是持有不让出的。
 *
 * ﻿如下代码在子线程睡眠期间主线程中断了它，
 * 所以子线程在调用 sleep 处抛出了 InterruptedException 异常
 *
 * auther lijie  2018/11/1.
 */
public class SleepInterruptTest {

    public static void main(String[] args) throws InterruptedException {

        //创建线程
        Thread thread = new Thread(new  Runnable() {
            public void run() {

                try {
                    System.out.println("child thread is in sleep");

                    Thread.sleep(10000);
                    System.out.println("child thread is in awaked");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        //启动线程
        thread.start();

        //主线程休眠2s
        Thread.sleep(2000);

        //主线程中断子线程
        thread.interrupt();
    }

}