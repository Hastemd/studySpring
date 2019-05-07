package designMode.DecoratorPattern;

/**
 * auther lijie  2019/5/7.
 */
public class Person {

    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public void show(){
        System.out.println(" 装扮的 " + name);
    }
}