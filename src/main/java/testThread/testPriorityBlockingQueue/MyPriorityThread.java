/**
 * Created by lijie on 2017/11/13.
 */
package testThread.testPriorityBlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * auther lijie  2017/11/13.
 * 使用优先队列时,任务线程必须实现Comparable接口,优先队列会根据该接口对任务进行排序
 */
public class MyPriorityThread implements Runnable,Comparable<MyPriorityThread> {
    @Override
    public int compareTo(MyPriorityThread o) {
        //比较任务的优先级
        int me = Integer.parseInt(this.name.split("_")[1]);
        int other = Integer.parseInt(o.name.split("_")[1]);
        if(me>other){
            return 1;
        }else if(me<other){
            return -1;
        }else{
            return 0;
        }

    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
            System.out.println(name + " ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String name;

    public MyPriorityThread(){

    }
    public MyPriorityThread(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(10,20,0L, TimeUnit.SECONDS,new PriorityBlockingQueue<Runnable>());

        for (int i = 0; i < 100; i++) {
            executorService.execute(new MyPriorityThread("testThreadPoolExecutor1_" + Integer.toString(99-i)));
        }
    }
}