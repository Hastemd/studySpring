package basic.testRegex;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * auther lijie  2019/1/21.
 */
public class PasswordRegex {


    /**
     * 解释：
     *
     * ^(?![A-Za-z]+$)表示从头到位不能全是字母
     * ^(?![0-9]+$)表示从头到位不能全是数字
     * ^(?![@#$]+$)表示从头到位不能全是符号@#$
     * ^[A-Za-z0-9@#$]{6,20}$表示从头到位只能是字母数字符号@#$的集合
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> pwdList = new ArrayList<String>();
        pwdList.add("aaaabbb");
        pwdList.add("@#@$@##@$@");
        pwdList.add("111111111");
        pwdList.add("111@#asdfas");
        String pwdRegex = "^(?![A-Za-z]+$)(?![0-9]+$)(?![@#$]+$)[A-Za-z0-9@#$]{6,20}$";
        Pattern pattern = Pattern.compile(pwdRegex);
        Matcher matcher;
        for (String pwd : pwdList) {
            matcher = pattern.matcher(pwd);
            if (matcher.find()) {
                System.out.println("密码" + pwd + "符合规则");
            } else {
                System.out.println("密码" + pwd + "不符合规则...");
            }
        }
    }

}