package basic.java8;

import java.util.Objects;
import java.util.function.Function;

/**
 * TODO(描述)
 *
 * @author lijie
 * @date 2021/12/30 9:34 上午
 */
public class TestFunction {

    public static void main(String[] args) {
        //Function<Integer, Integer> func1 = i -> i + i;
        //Function<Integer, Integer> func2 = i -> i * i;
        //
        //System.out.println(func1.compose(func2).apply(3));
        //System.out.println(func1.andThen(func2).apply(3));

        allContent();
    }

    private static void allContent() {
        Function<Integer, Integer> func1 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer i) {
                return i + i;
            }
        };

        Function<Integer, Integer> func2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer i) {
                return i + i;
            }
        };

        Function<Integer, Integer> compose = func1.compose(func2);
        /**
         * compose.apply(3);
         * 这个 compose 是 (V v) -> apply(before.apply(v))
         *
         * @author lijie
         * @date 2021/12/30 10:18 上午:
         */
        Integer apply = compose.apply(3);
        System.out.println(apply);
        System.out.println(func1.compose(func2).apply(3));


    }
}
