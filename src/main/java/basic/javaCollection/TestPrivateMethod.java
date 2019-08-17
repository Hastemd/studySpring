package basic.javaCollection;

/**
 * auther lijie  2019/8/1.
 */
public class TestPrivateMethod {

    private int a;

    public void sayHello(){
        System.out.println("hello");
        this.sayHi();
    }

    private void sayHi(){
        System.out.println("he");
    }

}