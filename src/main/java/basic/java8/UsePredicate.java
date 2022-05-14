package basic.java8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 使用 Predicate
 *
 * @author lijie
 * @date 2022/1/2 20:41
 */
@Slf4j
public class UsePredicate {
    public static void main(String[] args) {
        List<Person> collect = Stream.of(new Person("irisha", 18),
                new Person("hastemd", 20)).collect(Collectors.toList());

        List<Person> collect1 = collect.stream()
                .filter(a -> a.getAge() > 16)
                .filter(a -> a.getName().length() > 4)
                .collect(Collectors.toList());
        log.info("基本使用: {}", collect1);

        List<Person> collect2 = collect.stream().filter(a -> a.getAge() > 16 && a.getName().length() > 4)
                .collect(Collectors.toList());
        log.info("基本使用2: {}", collect2);

        // 定义 predicate
        Predicate<Person> predicate1 = s -> s.getAge() > 16;
        Predicate<Person> predicate2 = s -> s.getName().length() > 4;
        List<Person> collect3 = collect.stream().filter(predicate1.and(predicate2))
                .collect(Collectors.toList());
        log.info("组合 Predicate1: {}", collect3);

        //实际上，我们并不需要显示的assign一个predicate，只要是满足
        //predicate接口的lambda表达式都可以看做是一个predicate。同样可以调用and，or和negate操作：
        List<Person> collect4 = collect.stream()
                .filter(((Predicate<Person>)s -> s.getAge() > 16).and(s -> s.getName().length() > 4))
                .collect(Collectors.toList());
        log.info("组合 Predicate2: {}", collect4);

        // 使用 reduce 方法
        List<Predicate> allPredicate = Stream.of(predicate1, predicate2).collect(Collectors.toList());
        val collect5 = collect.stream().filter(allPredicate.stream().reduce(x -> true, Predicate::and))
                .collect(Collectors.toList());
        log.info("Predicate 使用 reduce: {}", collect5);

    }
}

@Data
@AllArgsConstructor
class Person{
    private String name;

    private int age;
}
