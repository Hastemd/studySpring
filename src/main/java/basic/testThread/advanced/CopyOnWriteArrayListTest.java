package basic.testThread.advanced;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList : 弱一致性
 * 其内部,是一个copy的数组
 * ﻿CopyOnWriteArrayList 使用写时拷贝的策略来保证list的一致性，
 * 而获取-拷贝-写入三步并不是原子性的，所以在修改增删改的过程中都使用了独占锁，
 * 保证了同时只有一个线程才能对list数组进行修改。
 * 另外 CopyOnWriteArrayList 提供了弱一致性的迭代器，
 * 保证在获取迭代器后，其它线程对list的修改不可见，
 * 迭代器遍历时候的数组是获取迭代器时候的一个快照
 * auther lijie  2018/11/2.
 */
public class CopyOnWriteArrayListTest {

    private static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        arrayList.add("hello");
        arrayList.add("alibaba");
        arrayList.add("welcome");
        arrayList.add("to");
        arrayList.add("hangzhou");

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                arrayList.set(1,"baba");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //remove
                arrayList.remove(2);
                arrayList.remove(3);

                for(String str : arrayList){
                    System.out.println("threadOne : " + str);
                }
            }
        });

        Iterator<String> iterator = arrayList.iterator();
        threadOne.start();
        threadOne.join();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

}