package basic.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * java8 中的[方法引用] '双冒号'  ::
 *
 * 表达式
 *      person -> person.getAge();
 *      可以替换成:
 *      Person::getAge
 *
 * 表达式
 *      ()-> new HashMap<>();
 *      可以替换成:
 *      HashMap::new
 *
 * auther lijie  2019/7/1.
 */
public class DoubleColonTest {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("adfa");
        stringList.add("dfasf");
        List<String> collect = stringList.stream().map(string -> string.toUpperCase()).collect(Collectors.toList());
        collect.forEach(System.out::println);


        List<String> list = new ArrayList<>();
        list.add("dfsgsdf");
        list.add("gdfdsf");
        list.add("adfaf");
        ArrayList<String> collect1 = list.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));
        ArrayList<String> collect2 = list.stream().map(String::toUpperCase).collect(Collectors.toCollection(() -> new ArrayList<>()));
        collect1.forEach(System.out::println);
        System.out.println(collect1);
        System.out.println(collect2);
    }

}