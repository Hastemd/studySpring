package designMode.DecoratorPattern;

/**
 * auther lijie  2019/5/7.
 */
public class TShirts extends FineryDecorator {

    @Override
    public void show(){
        System.out.print("大T恤 ");
        super.show();
    }
}