package designMode.DecoratorPattern;

/**
 * auther lijie  2019/5/7.
 */
public class BigTrouser extends FineryDecorator {

    @Override
    public void show(){
        System.out.print("垮裤 ");
        super.show();
    }
}