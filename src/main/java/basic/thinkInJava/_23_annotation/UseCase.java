package basic.thinkInJava._23_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @url https://github.com/Hastemd/OnJava8/blob/master/docs/book/23-Annotations.md
 * auther lijie  2019/8/17.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {

    int id();
    String description() default "no description";

}