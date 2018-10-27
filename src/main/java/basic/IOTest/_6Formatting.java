package basic.IOTest;

/**
 * auther lijie  2018/10/24.
 */
public class _6Formatting {


    public static void main(String[] args) {


        //i和r变量被格式化了两次:
        // 第一次使用重载打印中的代码，
        // 第二次使用Java编译器自动生成的转换代码，
        // Java编译器也使用toString。您可以用这种方式格式化任何值，但是您无法控制结果。

       /* int i = 2;
        double r = Math.sqrt(i);

        System.out.print("The square root of ");
        System.out.print(i);
        System.out.print(" is ");
        System.out.print(r);
        System.out.println(".");

        i = 5;
        r = Math.sqrt(i);
        System.out.println("The square root of " + i + " is " + r + ".");*/


        //d formats an integer value as a decimal value.
        //f formats a floating point value as a decimal value.
        //n outputs a platform-specific line terminator.
        int i = 2;
        double r = Math.sqrt(i);

        //除了%% 和%n, 所有格式说明符都必须与参数匹配。如果不这样做, 将引发异常。
        //在Java编程语言中，\n转义总是生成linefeed字符(\ u 000A)。不要使用\n，除非你特别想要换行字符。要为本地平台获得正确的行分隔符，请使用%n。
        System.out.format("The square root of %d is %f.%n", i, r);
        System.out.println("aaa");
        System.out.format("%f, %1$+015.10f %n", Math.PI);
        System.out.format("%f, %<+020.10f %n", Math.PI);
    }


}