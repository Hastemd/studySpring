package basic.javaCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * auther lijie  2019/5/8.
 */
public class FinalList {

    public static void main(String[] args) {
        final List<String> strList = new ArrayList<>();
        strList.add("hello");
        strList.add("world");
        System.out.println(strList);

        List<String> asList = Arrays.asList("a", "b", "c");
        asList.add("dd");
        System.out.println(asList);


    }

}