package designMode.DecoratorPattern;

/**
 * auther lijie  2019/5/7.
 */
public class TestDecorator {

    public static void main(String[] args) {
        Person person = new Person("iris");
        System.out.println("第一种装扮");
        BigTrouser bigTrouser = new BigTrouser();
        TShirts tShirts = new TShirts();
        bigTrouser.decorator(person);
        tShirts.decorator(bigTrouser);
        tShirts.show();

        System.out.println("第二种装扮");
    }

}