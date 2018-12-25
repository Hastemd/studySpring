package basic.testThread.advanced.countDownLatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA问题
 * java提供了 AtomicStampedReference
 * @see AtomicStampedReference
 * 来解决这个问题,
 * 它基于版本号或者说是一种状态,在修改的过程中不仅仅对比值,也同时会对比版本号
 * auther lijie  2018/12/17.
 */
public class AtomicReferenceABATest {

    public static AtomicReference<String> ATOMIC_REFERENCE = new AtomicReference<>("haha");
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    private final static Random RANDOM_OBJECT = new Random();

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
                        Thread.sleep(RANDOM_OBJECT.nextInt() & 500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(ATOMIC_REFERENCE.compareAndSet(oldValue,oldValue+num)){
                        System.out.println("线程 : " + num + ",进行了对象修改!,结果为 : " + oldValue+num);
                    }
                }
            };
            threads[i].start();

        }
        Thread.sleep(200);
        countDownLatch.countDown();

        new Thread(){
            public void run(){
                try {
                    Thread.sleep(RANDOM_OBJECT.nextInt() & 200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                while(!ATOMIC_REFERENCE.compareAndSet(ATOMIC_REFERENCE.get(),"haha"));
                System.out.println("已经修改为原始值");
            }
        }.start();

        Thread.sleep(2000);

        System.out.println("最终结果为: " + ATOMIC_REFERENCE.get());
    }

}