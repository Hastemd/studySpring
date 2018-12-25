package basic.testThread.advanced.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 引用的原子修改
 * auther lijie  2018/12/17.
 *
 */
public class AtomicReferenceTest {

    public static AtomicReference<String> ATOMIC_REFERENCE = new AtomicReference<>("haha");
    static CountDownLatch countDownLatch = new CountDownLatch(1);
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            final int num = i;
            threads[i] = new Thread(){
                public void run(){
                    String oldValue = ATOMIC_REFERENCE.get();
                    System.out.println("线程 : " + num + ",获取oldValue : " + oldValue);
                    try {
                        countDownLatch.await();
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(ATOMIC_REFERENCE.compareAndSet(oldValue,oldValue+num)){
                        System.out.println("线程 : " + num + ",进行了对象修改!");
                    }
                }
            };
            threads[i].start();

        }
        countDownLatch.countDown();
        Thread.sleep(2000);


        //for(Thread thread : threads){
        //    thread.join();
        //}
        System.out.println("最终结果为: " + ATOMIC_REFERENCE.get());
    }

}