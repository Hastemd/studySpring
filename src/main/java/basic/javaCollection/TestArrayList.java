package basic.javaCollection;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 拜读 源码
 * @see java.util.ArrayList
 * auther lijie  2019/7/31.
 */
public class TestArrayList {

    public static void main(String[] args) throws NoSuchMethodException, IOException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        TestPrivateMethod test = new TestPrivateMethod();
        test.sayHello();

        List<Integer> list = new ArrayList();
        Integer a = new Integer(1111);
        System.out.println("add......");
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //list.add(5);
        //list.add(6);
        //list.add(7);
        //list.add(8);
        //list.add(9);
        //list.add(10);
        //list.add(11);

        //Object clone = ((ArrayList<Integer>) list).clone();
        //list.remove(a);
        //
        //System.out.println(list);
        //System.out.println(clone);
        //System.out.println("clone......");
        //
        //Integer[] array = new Integer[3];
        //array[0] = 0;
        //array[2] = 2;
        //Integer[] toArray = list.toArray(array);
        //System.out.println(toArray.toString());
        //System.out.println(Arrays.toString(toArray));
        //
        //list.add(1,11);
        //System.out.println(list);

        //list.add(null);
        //boolean remove = list.remove(null);
        //System.out.println(remove);
        //
        //String fileName = "/Users/lijie/IdeaProjects/studyspring/src/main/java/com/example/lijie/IOTest/WriteArrayList.txt";
        //ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));
        //output.writeObject(list);
        //output.flush();
        //output.close();
        //System.out.println("---ArrayListObject--write--over!");
        //
        ///** 反序列化 */
        //FileInputStream fileInputStream = new FileInputStream(fileName);
        //ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        //ArrayList readList = (ArrayList) inputStream.readObject();
        //readList.add(9);
        //System.out.println(readList);


        //Iterator<Integer> iterator = list.iterator();
        //int i = 0;
        //while(iterator.hasNext()){
        //
        //    System.out.println("iterator : " + iterator.next());
        //    if(i == 2){
        //        iterator.remove();
        //    }
        //    i++;        }
        //System.out.println(list);

        //List<Integer> subList = list.subList(1, 3);
        //System.out.println(subList.get(0));
        //
        //List<Integer> subList1 = list.subList(0, 1);
        //System.out.println(subList1.get(0));

        List<String> stringList = Arrays.asList("1", "2", "3");
        String[] b = {"a","b","c","d"};
        String[] toArrayb = stringList.toArray(b);
        System.out.println(Arrays.toString(toArrayb));
        //stringList.remove(0);
        System.out.println(stringList);

        int ai = 55;
        for(int i = 0 ; i < 32 ; i++){
            int t = (ai & 0x80000000 >>> i);
            int t1 = t >>> (31-i);
            System.out.print(t1);
        }

    }

}