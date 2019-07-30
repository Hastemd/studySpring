package basic.java8;

import java.util.Optional;

/**
 * Optional 类是一个可以为null的容器对象
 * 如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象
 * auther lijie  2019/7/1.
 */
public class OptionalTest {

    public static void main(String[] args) {
        OptionalTest optional = new OptionalTest();
        Integer value1 = null;
        Integer value2 = new Integer(666);

        Optional<Integer> a = Optional.ofNullable(value1);
        Optional<Integer> b = Optional.of(value2);
        System.out.println(optional.sum(a,b));
    }

    private Integer sum(Optional<Integer> a, Optional<Integer> b) {
        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        Integer value1 = a.orElse(new Integer(0));
        Integer value2 = b.get();
        return value1 + value2;
    }

}