package basic.javaCollection;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * auther lijie  2019/5/9.
 */
public class TestLinkedHashMap {

    public static void main(String[] args) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>(16, 0.75F,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String,String> eldest){
                return size() > 3;
            }
        };

        linkedHashMap.put("project1","java");
        linkedHashMap.put("project2","javascript");
        linkedHashMap.put("project3","html");
        for(Map.Entry<String, String> s : linkedHashMap.entrySet()){
            System.out.println(s.getKey() + ":" + s.getValue());
        }
        System.out.println("------------------------------");
        //lamda表达式?
        linkedHashMap.forEach( (k,v) ->{
            System.out.println(k + ":" +v);
        });
        System.out.println("------------------------------");

        linkedHashMap.get("project2");
        linkedHashMap.get("project2");
        linkedHashMap.get("project3");
        System.out.println("Iterate over should be not affected:");
        linkedHashMap.forEach((k,v)->{
            System.out.println(k + ":" +v);
        });
        System.out.println("------------------------------");

        //触发删除
        linkedHashMap.put("project4","spring");
        System.out.println("Oldest entry should be removed");
        linkedHashMap.forEach((k,v)->{
            System.out.println(k + ":" + v);
        });

    }

}