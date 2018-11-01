package basic.testThread;

/**
 * auther lijie  2018/11/1.
 */
public class InterruptedTest {

public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //如果当前线程被中断则退出循环
                while (!Thread.currentThread().isInterrupted())
                    System.out.println(Thread.currentThread() + " hello");
            }
        });

        //启动子线程
        thread.start();

        //主线程休眠1s，以便中断前让子线程输出点东西
        Thread.sleep(1);

        //中断子线程
        System.out.println("main thread interrupt thread");
        thread.interrupt();

        //等待子线程执行完毕
        thread.join();
        System.out.println("main is over");

       /* //线程one
        final Thread threadOne = new Thread(new Runnable() {

            @Override
            public void run() {

                //System.out.println("threadOne begin run!");
                //for (;;) {
                //}

                while(!Thread.currentThread().isInterrupted()){
                    System.out.println(Thread.currentThread() + "hello");
                }

            }
        });
        //获取主线程
        final Thread mainThread = Thread.currentThread();

        //线程two
        Thread threadTwo = new Thread(new Runnable() {

            @Override
            public void run() {
                //休眠1s
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //中断主线程
                threadOne.interrupt();

            }
        });

        // 启动子线程
        threadOne.start();
        //延迟1s启动线程
        threadTwo.start();

        try{//等待线程one执行结束
            threadOne.join();

        }catch(InterruptedException e){
            System.out.println("main thread:" + e);
            e.printStackTrace();
        }*/

    }

}