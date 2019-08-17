package basic.javaCollection;

import java.util.HashMap;
import java.util.Map;

/**
 * 拜读一下
 * @see java.util.HashMap 的源码
 * auther lijie  2019/7/30.
 */
public class TestHashMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("a","aaa");
        map.put("b","bbb");

        for(Map.Entry<String,String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

}