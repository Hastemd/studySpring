package basic.java8.thinkInJava.chapter13.RunnableReference;

/**
 * auther lijie  2019/8/13.
 */
public class RunnableMethodReference {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " :Anonymous");
            }
        }).start();

        new Thread(() -> System.out.println(Thread.currentThread().getName() + " :lambda")).start();

        new Thread(Go::go).start();
    }

}