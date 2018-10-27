package com.example.lijie.IOTest;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.*;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.HashSet;
import java.util.Set;

/**
 * 下面的示例是为UNIX和其他POSIX文件系统编写的，
 * 它创建了具有特定文件权限集的日志文件。
 * 如果日志文件已经存在，则此代码将创建日志文件或将其追加到日志文件中。
 * 日志文件的创建具有所有者的读/写权限和组的只读权限。
 * auther lijie  2018/10/25.
 */
public class _9_LogFilePermissionsTest {

    public static void main(String[] args) {

        // Create the set of options for appending to the file.
        Set<OpenOption> options = new HashSet<OpenOption>();
        options.add(StandardOpenOption.APPEND);
        options.add(StandardOpenOption.CREATE);

        // Create the custom permissions attribute.
        Set<PosixFilePermission> perms =
                PosixFilePermissions.fromString("rw-r-----");
        FileAttribute<Set<PosixFilePermission>> attr =
                PosixFilePermissions.asFileAttribute(perms);

        // Convert the string to a ByteBuffer.
        String s = "Hello World! ";
        byte data[] = s.getBytes();
        ByteBuffer bb = ByteBuffer.wrap(data);

        Path file = Paths.get("./src/main/java/com/example/lijie/IOTest/permissions.log");

        try (SeekableByteChannel sbc =
                     Files.newByteChannel(file, options, attr)) {
            sbc.write(bb);
        } catch (IOException x) {
            System.out.println("Exception thrown: " + x);
        }

        Iterable<Path> dirs = FileSystems.getDefault().getRootDirectories();
        for (Path name: dirs) {
            System.out.println(name);
        }

        try {
            aaa();
        } catch (IOException e) {
            System.out.println("异常: " + e);
        }


    }


    public static void aaa() throws IOException {
        System.out.println("开始调用bbb方法");
        bbb();
        System.out.println("调用bbb方法结束");
    }

    private static void bbb() throws IOException {
        try {
            throw new IOException("调用gis超时了...");
        } catch (IOException e) {
            throw new IOException("调用gis超时了...");
        }
    }
}