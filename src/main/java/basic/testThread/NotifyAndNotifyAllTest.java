package basic.testThread;

/**
 * auther lijie  2018/11/1.
 */
public class NotifyAndNotifyAllTest {

    private static volatile Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {

        // 创建线程
        Thread threadA = new Thread(new Runnable() {
            public void run() {
                // 获取resourceA共享资源的监视器锁
                synchronized (resourceA) {
                    System.out.println("threadA get resourceA lock");
                    try {
                        System.out.println("threadA begin wait");
                        resourceA.wait();
                        System.out.println("threadA end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // 创建线程
        Thread threadB = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadB get resourceA lock");
                    try {
                        System.out.println("threadB begin wait");
                        resourceA.wait();
                        System.out.println("threadB end wait");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        });

        // 创建线程
        Thread threadC = new Thread(new Runnable() {
            public void run() {
                synchronized (resourceA) {
                    System.out.println("threadC begin notify");
                    //notify(),只唤醒一个线程,程序不会结束
                    //resourceA.notify();

                    //notifyAll(),唤醒所有在此对象上wait()的线程,他们去抢锁
                    resourceA.notifyAll();
                }
            }
        });

        // 启动线程
        threadA.start();
        threadB.start();

        Thread.sleep(1000);
        threadC.start();

        // 等待线程结束
        threadA.join();
        threadB.join();
        threadC.join();
        System.out.println("main over");
    }

}