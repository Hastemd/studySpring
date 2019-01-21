package basic.testRegex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 抓取手机验证码
 * auther lijie  2019/1/21.
 */
public class PhoneVerificationCode {


    public static void main(String[] args) {

        /**
         * "验证码"3个字在数字前，可以regex=验证码\D(\d{4}|\d{6})，
         * “验证码”3个字在数字后，可以regex=(\d{4}|\d{6})\D验证码，
         * 这2个表达式是或的关系，需要用到括号来组织这2个表达式，然后再用或“|”来进行选择，即regex=(验证码\D(\d{4}|\d{6}))|((\d{4}|\d{6})\D验证码)
         *
         * 由于要通过捕获组( )来获取数字内容，又要用括号来组织关系，因此需要把或“|”两边的表达式部分用非捕获组(?:)来标记，
         * 因为我们只需要获取数字部分的括号( )匹配到的数字。即regex=(?:验证码\D(\d{4}|\d{6}))|(?:(\d{4}|\d{6})\D验证码)
         * 最后我们把分析到的表达式代入到Java代码完成功能。注意在Java中，反斜杠需要转义，即一杠变二杠。
         *
         */
        List<String> inputList = new ArrayList<String>(16);
        inputList.add("【京东】尊敬的用户，634561是您本次的省份验证码，30分钟内有效，请完成验证。");
        inputList.add("滴滴】您的验证码是6678，请在页面中提交验证码完成验证。");
        inputList.add("【百度】376687（动态验证码），请在30分钟内填写。");
        String regex = "(?:验证码\\D*(\\d{4}|\\d{6}))|(?:(\\d{4}|\\d{6})\\D*验证码)";
        Pattern pattern = Pattern.compile(regex);
        System.out.println("一键获取到的验证码如下：");
        for (String input : inputList) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                for (int i = 1; i <= matcher.groupCount(); i++) {
                    if (matcher.group(i) != null) {
                        System.out.println(matcher.group(i));
                    }
                }
            }
        }
    }


    /*public static void main(String[] args) {
        String str = "2018-11-13";
        String reg = "(\\d{4})-(\\d{2})-(\\d{2})";
        System.out.println(str.matches(reg));

        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(str);
        if(matcher.find()){
            for (int i = 1; i <= matcher.groupCount(); i++) {
                if (matcher.group(i) != null) {
                    System.out.println(matcher.group(i));
                }
            }
        }
    }*/

}