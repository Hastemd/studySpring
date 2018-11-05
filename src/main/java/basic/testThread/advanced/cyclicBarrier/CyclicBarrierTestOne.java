package basic.testThread.advanced.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ﻿CyclicBarrier 类的功能不限于 CountDownLatch 所提供的功能，
 * 从字面意思理解 CyclicBarrier 是回环屏障的意思，
 * 它可以实现让一组线程全部到达一个状态后再全部同时执行。
 * 这里之所以叫做回环是因为当所有等待线程执行完毕之后，
 * 重置 CyclicBarrier 的状态后可以被重用。
 *
 * auther lijie  2018/11/5.
 */
public class CyclicBarrierTestOne {

    private static volatile CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
        @Override
        public void run(){
            System.out.println(Thread.currentThread() + " task1 merge result");
        }
    });

    /**
     * @Description ﻿一开始计数器为 2，当第一个线程调用 await 方法时候，计数器会递减为 1，由于计数器不为 0，
     * 所以当前线程就到了屏障点会被阻塞，然后第二个线程调用 await 时候，会进入屏障，计数器也会递减现在计数器为 0，
     * 就会去执行在 CyclicBarrier 构造时候的任务，执行完毕后就会退出屏障点，
     * 并且会唤醒被阻塞的第一个线程，这时候第一个线程也会退出屏障点继续向下运行。
     *
     * @Author 李杰 lijie@ane56.com
     * @Date 2018/11/5 10:41 AM
     */
    public static void main(String[] args) {
        //创建一个线程个数固定为2的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " task-1");
                System.out.println(Thread.currentThread() + " enter in barrier");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " enter out barrier");
            }
        });

        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " task-2");
                System.out.println(Thread.currentThread() + " enter in barrier");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " enter out barrier");
            }
        });

        executorService.shutdown();
    }

}