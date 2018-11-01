package basic.testThread;

/**
 * 守护线程
 * auther lijie  2018/11/1.
 */
public class DaemonTest {

    public static void main(String[] args) {
        Thread daemonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(;;){

                }
            }
        });

        //必须在start()前,设置为守护线程
        daemonThread.setDaemon(true);
        daemonThread.start();
        daemonThread.start();
        System.out.println("main thread is over!");
    }

}