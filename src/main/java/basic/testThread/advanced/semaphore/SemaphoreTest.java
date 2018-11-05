package basic.testThread.advanced.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * auther lijie  2018/11/5.
 */
public class SemaphoreTest {

    // 创建一个Semaphore实例
    private static volatile Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 加入线程A到线程池
        executorService.submit(new Runnable() {
            public void run() {
                try {
                    System.out.println(Thread.currentThread() +  " over");
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // 加入线程B到线程池
        executorService.submit(new Runnable() {
            public void run() {
                try {
                    System.out.println(Thread.currentThread() +  " over");
                    semaphore.release();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        // 等待子线程执行完毕，返回
        semaphore.acquire(2);
        System.out.println("all child thread over!");

        //关闭线程池
        executorService.shutdown();
    }

}