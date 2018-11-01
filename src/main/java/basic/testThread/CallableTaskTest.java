package basic.testThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Callable接口,可以有返回值
 * auther lijie  2018/11/1.
 */
public class CallableTaskTest implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "hello";
    }

    public static void main(String[] args) {
        Callable callable = new CallableTaskTest();
        FutureTask<String> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();

        try {
            String s = futureTask.get();
            System.out.println("获取到返回信息 : " + s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("main运行结束了...");
    }

}