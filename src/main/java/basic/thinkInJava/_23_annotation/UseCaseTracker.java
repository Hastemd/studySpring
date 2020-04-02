package basic.thinkInJava._23_annotation;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @see UseCase 注解处理器
 * auther lijie  2019/8/17.
 */
public class UseCaseTracker {

    public static void trackUseCases(List<Integer> useCases, Class cl){
        for(Method m : cl.getDeclaredMethods()){
            UseCase annotation = m.getAnnotation(UseCase.class);
            if(annotation != null){
                System.out.println("Found Use Case " + annotation.id() + "\n" + annotation.description());
                useCases.remove(Integer.valueOf(annotation.id()));
            }
        }

        useCases.forEach(i -> System.out.println("Missing use case " + i));
    }

    public static void main(String[] args) {
        List<Integer> useCases = IntStream.range(1, 9).boxed().collect(Collectors.toList());
        trackUseCases(useCases,PasswordUtils.class);
    }

}