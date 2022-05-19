package basic.javaCollection;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 测试下 list 的 remove 方法
 *
 * @author lijie
 * @date 2022/5/18 18:16
 */
@Slf4j
public class TestListRemove {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        // 加了这个必然也报错,
        // hasNext 会先判断 cursor != size, 两个元素的话删掉一个这个就 false 了走不到 iterator.next()方法了
        // next() 会判断 modCount != expectedModCount 不同就报错了
        //stringList.add("c");
        log.info("before list: {}", stringList);

        Iterator<String> iterator = stringList.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            if(next.equals("a")){   //不报错
            //if(next.equals("b")){ // 报错
                stringList.remove(next);
            }
        }

        log.info("after rome list: {}", stringList);

    }
}
