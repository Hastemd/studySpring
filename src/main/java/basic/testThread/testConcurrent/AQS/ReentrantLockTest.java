package basic.testThread.testConcurrent.AQS;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * auther lijie  2018/11/2.
 */
public class ReentrantLockTest {

    static ReentrantLock lock = new ReentrantLock();//(1)
    static Condition condition = lock.newCondition();//(2)

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();//(3)
                try {
                    System.out.println("begin wait");
                    condition.await();//(4)
                    System.out.println("end wait");

                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                    lock.unlock();//(5)
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.lock();//(6)
                try {
                    System.out.println("begin signal");
                    condition.signal();//(7)
                    System.out.println("end signal");
                } catch (Exception e) {
                    e.printStackTrace();

                } finally {
                    lock.unlock();//(8)
                }
            }
        }).start();

    }

}