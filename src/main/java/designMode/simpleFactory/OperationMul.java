package designMode.simpleFactory;

/**
 * 乘法类
 * auther lijie  2019/5/5.
 */
public class OperationMul extends Operation{

    @Override
    public double getResult(){
        double result = 0;
        result = numberA * numberB;
        return result;
    }

}