package basic.java8.thinkInJava.chapter13.produceFunction;

import java.util.function.Function;

/**
 * 这里，produce() 是高阶函数。
 * [1] 使用继承，可以轻松地为专用接口创建别名。
 * [2] 使用 Lambda 表达式，可以轻松地在方法中创建和返回一个函数。
 * auther lijie  2019/8/13.
 */
public class ProduceFunction {

    static Funcss produce(){
        //[2]
        return s -> s.toLowerCase();
    }

    public static void main(String[] args) {
        //ProduceFunction pf = new ProduceFunction();
        //Funcss f1 = pf::produce();
        Funcss f = produce();
        System.out.println(f.apply("YELLOW"));
    }

}

//[1]
interface Funcss extends Function<String,String>{}