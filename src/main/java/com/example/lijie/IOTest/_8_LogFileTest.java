package com.example.lijie.IOTest;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * auther lijie  2018/10/25.
 */
public class _8_LogFileTest {

    public static void main(String[] args) {

        // Convert the string to a
        // byte array.
        String s = "Hello World! ";
        byte data[] = s.getBytes();
        Path p = Paths.get("./src/main/java/com/example/lijie/IOTest/logfile.txt");

        try (OutputStream out = new BufferedOutputStream(
                Files.newOutputStream(p, StandardOpenOption.CREATE, StandardOpenOption.APPEND))) {
            out.write(data, 0, data.length);
        } catch (IOException x) {
            System.err.println(x);
        }
    }
}