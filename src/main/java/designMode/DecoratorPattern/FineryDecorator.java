package designMode.DecoratorPattern;

/**
 * auther lijie  2019/5/7.
 */
public class FineryDecorator extends Person{

    protected Person component;

    public FineryDecorator(Person component) {
        this.component = component;
    }
    public FineryDecorator() {
    }

    public void decorator(Person component){
        this.component = component;
    }

    @Override
    public void show(){
        if(component != null){
            component.show();
        }
    }

}