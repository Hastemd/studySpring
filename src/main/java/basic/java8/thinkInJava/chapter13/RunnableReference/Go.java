package basic.java8.thinkInJava.chapter13.RunnableReference;

/**
 * @see Runnable
 * Runnable 接口自 1.0 版以来一直在 Java 中，因此不需要导入。
 * 它也符合特殊的单方法接口格式：它的方法 run() 不带参数，也没有返回值。
 * 因此，我们可以使用 Lambda 表达式和方法引用作为 Runnable：
 * auther lijie  2019/8/13.
 */
public class Go {

    static void go(){
        System.out.println("Go::go()");
        System.out.println(Thread.currentThread().getName() + " :Go::go()");
    }

}