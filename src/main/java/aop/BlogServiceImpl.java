/**
 * Created by lijie on 2017/9/21.
 */
package aop;

import org.junit.Test;

import java.lang.annotation.Target;
import java.lang.reflect.Proxy;
import java.util.logging.Handler;

/**
 * auther lijie  2017/9/21.
 */
public class BlogServiceImpl implements IBlogService{

    public void removeTopic(int topicId){
        //PerformanceMonitor.begin("aop.removeTopic.removeTopic");
        System.out.println("模拟删除Topic记录: " + topicId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //PerformanceMonitor.end();
    }

    public void removeForum(int forumId){
        //PerformanceMonitor.begin("aop.removeTopic.removeForum");
        System.out.println("模拟删除forum记录: " + forumId);
        try {
            Thread.currentThread().sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //PerformanceMonitor.end();
    }

    @Test
    public void proxt(){
        BlogServiceImpl targer = new BlogServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(targer);
        IBlogService proxyInstance = (IBlogService)Proxy.newProxyInstance(
                targer.getClass().getClassLoader(), targer.getClass().getInterfaces(), handler);
        proxyInstance.removeForum(1);
        proxyInstance.removeTopic(2);
    }
}