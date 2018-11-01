package basic.testThread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * ﻿Thread 类中有一个静态的 sleep 方法，
 * 当一个执行中的线程调用了 Thread 的 sleep 方法后，
 * 调用线程会暂时让出指定时间的执行权，也就是这期间不参与 CPU 的调度，
 * 但是该线程所拥有的监视器资源，比如锁还是持有不让出的。
 *
 * 当指定的睡眠时间到了该函数会正常返回，线程就处于就绪状态，然后参与 CPU 的调度，
 * 当获取到了 CPU 资源就可以继续运行了。如果在睡眠期间其它线程调用了该线程的 interrupt() 方法中断了该线程,
 * 该线程会在调用 sleep 的地方抛出 InterruptedException 异常返回
 * auther lijie  2018/11/1.
 */
public class SleepTest {

    // 创建一个独占锁
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {

        // 创建线程A
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                // 获取独占锁
                lock.lock();
                try {
                    System.out.println("child threadA is in sleep");

                    Thread.sleep(10000);

                    System.out.println("child threadA is in awaked");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放锁
                    lock.unlock();
                }
            }
        });

        // 创建线程B
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                // 获取独占锁
                lock.lock();
                try {
                    System.out.println("child threadB is in sleep");

                    Thread.sleep(10000);
                    System.out.println("child threadB is in awaked");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    // 释放锁
                    lock.unlock();
                }
            }
        });

        // 启动线程
        threadA.start();
        threadB.start();

    }

}