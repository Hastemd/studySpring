package com.example.lijie.testSpring;

import java.util.ArrayList;
import java.util.List;

/**
 * auther lijie  2019/1/23.
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
        System.out.println(list);
    }
}