/**
 * Created by lijie on 2017/7/30.
 */

import org.junit.Test;

/**
 * auther lijie  2017/7/30.
 */
public class TestTryCatchFinally {

    public static boolean catchMethod(){
        System.out.println("call cathcMethod and return --> ");
        return false;
    }

    public static void finallyMethod(){
        System.out.println();
        System.out.println("call finallyMethod and do something --> ");
    }

    //抛出 Exception , 没有 finally ,当 catch 遇上 return
    @Test
    public void catchTest(){
        try {
            int i = 10/0;
            System.out.println("i value is : " + i);
        } catch (Exception e) {
            System.out.println(" -- Exception --");
            System.out.println(catchMethod());
        }
    }
}