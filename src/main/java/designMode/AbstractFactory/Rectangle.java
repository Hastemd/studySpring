package designMode.AbstractFactory;

/**
 * auther lijie  2019/5/6.
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}