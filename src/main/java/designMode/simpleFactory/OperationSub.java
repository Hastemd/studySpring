package designMode.simpleFactory;

/**
 * 减法类
 * auther lijie  2019/5/5.
 */
public class OperationSub extends Operation{

    @Override
    public double getResult(){
        double result = 0;
        result = numberA - numberB;
        return result;
    }

}