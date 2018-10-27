package com.example.lijie.IOTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 学习io - 字节流
 * https://docs.oracle.com/javase/tutorial/essential/io/bytestreams.html
 * auther lijie  2018/10/24.
 *
 * 1,_1CopyBytes 将大部分时间花在一个简单的循环中, 它读取输入流, 并一次写入输出流 (一个字节), 如下图所示。
 *
 */
public class _1CopyBytes {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            in = new FileInputStream("/Users/lijie/IdeaProjects/studyspring/src/main/java/com/example/lijie/IOTest/xanadu.txt");
            out = new FileOutputStream("/Users/lijie/IdeaProjects/studyspring/src/main/java/com/example/lijie/IOTest/xanaduOut.txt");
            int c;

            while((c = in.read()) != -1){
                out.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(in != null){
                in.close();
            }
            if(out != null){
                out.close();
            }
        }
    }

}