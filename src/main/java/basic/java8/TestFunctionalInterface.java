package basic.java8;

/**
 * 函数式接口
 * auther lijie  2019/12/7.
 */
public class TestFunctionalInterface {

    public static void main(String[] args) {
        GreetingService greatService = str -> System.out.println("Hello :" + str);
        greatService.sayMessage("iris");
    }

}

interface GreetingService{
    void sayMessage(String message);
}