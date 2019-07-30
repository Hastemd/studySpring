package basic.java8;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 在Java 8中,集合接口有两个方法来生成流：
 *
 * stream() −为集合创建串行流。
 *
 * parallelStream() − 为集合创建并行流。
 * auther lijie  2019/7/1.
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("a","b","c","abc","","hafa","adf");
        List<String> filtered = stringList.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        filtered.forEach(System.out::print);
        System.out.println("-----------");

        List<String> filtered1 = stringList.stream().filter(string -> string.length() == 1).collect(Collectors.toList());
        filtered1.forEach(System.out::print);
        System.out.println("-----------");

        /*
        forEach : Stream 提供了新的方法 'forEach' 来迭代流中的每个数据
        */
        Random random = new Random();
        random.ints().limit(2).forEach(System.out::println);
        System.out.println("-----------");

        /*
        map : map 方法用于映射每个元素到对应的结果
        */
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3,7,3,5,1);
        // 获取对应的平方数
        List<Integer> squaresList = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
        squaresList.forEach(System.out::println);
        squaresList.forEach(System.out::print);
        System.out.println();
        System.out.println("-----------");

/*
        并行（parallel）程序
*/
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        // 获取空字符串的数量
        int count = (int) strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count);
        System.out.println("-----------");

/*
        Collectors
*/
        List<String> strings_9 = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<String> filtered_9 = strings_9.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("筛选列表: " + filtered_9);
        String mergedString = strings_9.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);
        System.out.println("-----------");

/*
        统计
*/
        List<Integer> numbers_10 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        IntSummaryStatistics stats = numbers_10.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());

        //groupingBy
        //    Collectors.groupingBy(p->p, Collectors.summingInt(p->1))
        //它的意思是：把结果收集到一个Map中，用统计到的各个素数自身作为键，其出现次数作为值。
        List<String> l = Arrays.asList("12","12","2","12");
        Map<Integer, Integer> r = l.stream()
                .map(e -> new Integer(e))
                .filter(e -> e%2 ==0)
                .collect( Collectors.groupingBy(p->p, Collectors.summingInt(p->1)) );
        System.out.println("primaryOccurrence result is: " + r);


    }
}