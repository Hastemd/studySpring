package basic.java8.thinkInJava.chapter13.methodReferences;

/** <b>方法引用</b>
 *
 *
 * [1] 我们从单一方法接口开始（同样，你很快就会了解到这一点的重要性）。
 * [2] show() 的签名（参数类型和返回类型）符合 Callable 的 call() 的签名。
 * [3] hello() 也符合 call() 的签名。
 * [4] help() 也符合，它是静态内部类中的非静态方法。
 * [5] assist() 是静态内部类中的静态方法。
 * [6] 我们将 Describe 对象的方法引用赋值给 Callable ，它没有 show() 方法，而是 call() 方法。 但是，Java 似乎接受用这个看似奇怪的赋值，因为方法引用符合 Callable 的 call() 方法的签名。
 * [7] 我们现在可以通过调用 call() 来调用 show()，因为 Java 将 call() 映射到 show()。
 * [8] 这是一个静态方法引用。
 * [9] 这是 [6] 的另一个版本：附加到存活对象的方法的方法参考，有时称为绑定方法引用。
 * [10] 最后，获取静态内部类的方法引用的操作与 [8] 中外部类方式一样。
 *
 * auther lijie  2019/8/13.
 * @see Callable
 * @see Describe
 */
public class MethodReferences {
    //[3]
    static void hello(String name){
        System.out.println("Hello, " + name);
    }

    static class Description{
        String about;
        Description(String desc){
            about = desc;
        }
        //[4]
        void help(String msg){
            System.out.println(about + " " + msg);
        }
    }

    static class Helper{
        //[5]
        static void assist(String msg){
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe();
        Callable c = d::show;
        //[7]
        c.call("call()");
        //[8]
        c = MethodReferences::hello;
        c.call("iris");
        //[9]
        c = new Description("static class")::help;
        c.call("information");
        //[10]
        c = Helper::assist;
        c.call("Help!");
    }
}