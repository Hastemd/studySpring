package com.example.lijie.IOTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
/**
 * @Description 读取一个文件,并按  Character.isWhitespace 分割
 * @Author 李杰 lijie@ane56.com
 * @Date 2018/10/24 3:27 PM
 */
public class _4ScanXan {
    public static void main(String[] args) throws IOException {

        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("/Users/lijie/IdeaProjects/studyspring/src/main/java/com/example/lijie/IOTest/xanadu.txt")));
            //为了使用不同的分割符,调用 useDelimiter() 方法,如下
            s.useDelimiter(",\\s*");
            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }
}