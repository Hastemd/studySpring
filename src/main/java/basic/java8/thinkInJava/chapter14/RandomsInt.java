package basic.java8.thinkInJava.chapter14;

import java.util.Random;

/**
 * auther lijie  2019/8/13.
 */
public class RandomsInt {

    public static void main(String[] args) {
        new Random(47)
                .ints(5,20)
                .distinct()
                .limit(7)
                .sorted()
                .forEach(System.out::println);
    }

}