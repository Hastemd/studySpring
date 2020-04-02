package basic.thinkInJava._23_annotation;

import java.util.List;

/**
 * 如果没有用于读取注解的工具,那么注解就没什么用了
 *
 * 使用
 * @see UseCase 注解
 * auther lijie  2019/8/17.
 */
public class PasswordUtils {

    @UseCase(id = 1, description = "Password must contain at least one numeric")
    public boolean validatePassword(String password){
        return password.matches("\\w+\\d\\w*");
    }

    @UseCase(id = 2)
    public String encryptPassword(String password){
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 3, description = "New passwords can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords , String password){
        return !prevPasswords.contains(password);
    }
}