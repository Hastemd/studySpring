package com.example.lijie.IOTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 学习io - 字符流 Reader和Writer
 * auther lijie  2018/10/24.
 */
public class _2CopyCharacters {

    public static void main(String[] args) throws IOException {
        FileReader reader = null;
        FileWriter writer = null;

        try {
            reader = new FileReader("/Users/lijie/IdeaProjects/studyspring/src/main/java/com/example/lijie/IOTest/xanadu.txt");
            writer = new FileWriter("/Users/lijie/IdeaProjects/studyspring/src/main/java/com/example/lijie/IOTest/characteroutput.txt");

            /*CopyCharacters中int 变量在其最后16位中保存字符值;在 _1CopyBytes 中, int 变量在其最后8位中保留字节值。*/
            int c;

            while((c = reader.read()) != -1){
                writer.write(c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(reader != null){
                reader.close();
            }
            if(writer != null){
                writer.close();
            }
        }
    }
}