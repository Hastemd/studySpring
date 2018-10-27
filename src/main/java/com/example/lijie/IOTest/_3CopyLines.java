package com.example.lijie.IOTest;

import java.io.*;

/**
 * 一行一行来处理,根据文本的换行符
 * auther lijie  2018/10/24.
 */
public class _3CopyLines {

    public static void main(String[] args) throws IOException {
        BufferedReader inputStream = null;
        PrintWriter outputStream = null;

        try {
            //Buffer 提高读写效率
            inputStream = new BufferedReader(new FileReader("/Users/lijie/IdeaProjects/studyspring/src/main/java/com/example/lijie/IOTest/xanadu.txt"));
            outputStream = new PrintWriter(new FileWriter("/Users/lijie/IdeaProjects/studyspring/src/main/java/com/example/lijie/IOTest/characteroutput.txt"));

            String l;
            while ((l = inputStream.readLine()) != null) {
                outputStream.println(l);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

}