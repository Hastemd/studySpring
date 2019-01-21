package basic.testRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Pattern类:
 *      1,Pattern是正则表达式regex的编译表示形式
 *      2,代码 Pattern pattern = Pattern.compile(regex);
 * Matcher类:
 *      1,通过解释Pattern对输入的字符串input执行匹配操作的引擎
 *      2,代码 Matcher matcher = pattern.matcher(input);
 * auther lijie  2019/1/21.
 */
public class TestRegex {

    public static void main(String[] args) {
        String input = "Hello regex 666!34";
        // java中要想表示\需要通过转义字符\进行转义
        String regex = "\\w+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        // matches()方法，将输入的整个字符串与给定的正则匹配
        System.out.println(matcher.matches());
        // 结果为：false，因为"Hello regex 666!"不全是\w

        String regex1 = "\\d+";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(input);
        // find()方法，从输入的字符串里找出与给定的正则匹配的子串
        while (matcher1.find()) {
            // 只要找到，则就能通过group()方法获取到符合条件的子串
            System.out.println(matcher1.group());
            // 结果为：666，通过find()找到了\d，通过group()方法获取匹配到的值
        }
    }

}