package basic.java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * auther lijie  2019/12/2.
 */
public class CreateStreamTest {

    public static void main(String[] args) {
        createStreamByFunctionIterate();
        System.out.println("--------");
        test1();
        test2();
    }

    //由函数生成流--迭代
    public static void createStreamByFunctionIterate() {
        System.out.println("---createStreamByFunctionIterate---");
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);
        //菲波纳契数列
        System.out.println("---createStreamByFunction-菲波纳契数列---");
        Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]})
                .limit(10)
                .map(t -> t[0])
                .forEach(System.out::println);
    }

    /**
     * 列出 列表里面各个不相同的字符
     */
    public static void test1(){
        List<String> words = Arrays.asList("Hello","World");
        List<String[]> list = words.stream()
                //这个方法的问题在于，传递给 map 方法的Lambda为每个单词返回了一个 String[] （ String列表）。
                // 因此， map 返回的流实际上是 Stream
                .map(word -> word.split(""))
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list);
    }

    /**
     * 列出 列表里面各个不相同的字符
     */
    public static void test2(){
        List<String> words = Arrays.asList("Hello","World");
        List<String> list = words.stream()
                //这个方法的问题在于，传递给 map 方法的Lambda为每个单词返回了一个 String[] （ String列表）。
                // 因此， map 返回的流实际上是 Stream
                .map(word -> word.split(""))
                //flatMap(Arrays::stream) 的效果就是 把两个流合并起来,即扁平化为一个流.
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(list);
    }

    @Test
    public void test3(){
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        //Integer reduce = integers.stream().reduce(0, (a, b) -> a + b);
        Integer reduce = integers.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
    }

    @Test
    public void test4(){
        Stream.of("one", "two", "three", "four")
            .filter(e -> e.length() > 3)
            .peek(e -> System.out.println("Filtered value: " + e))
            .map(String::toUpperCase)
            .peek(e -> System.out.println("Mapped value: " + e))
            .collect(Collectors.toList());
    }

    @Test
    public void test5() {
        Map<String, List<String>> conflictingGetters = new HashMap<>();
        ArrayList arrayList = new ArrayList();
        arrayList.add("a");
        arrayList.add("b");
        conflictingGetters.put("bbb",arrayList);
        System.out.println(conflictingGetters);
        List<String> list = conflictingGetters.computeIfAbsent("aaa", k -> new ArrayList<>());
        System.out.println(list);
        list.add("value-a");
        list.add("value-b");
        System.out.println(conflictingGetters);
        Collection<List<String>> values = conflictingGetters.values();
        System.out.println(values);

    }
}