package designMode.simpleFactory;

/**
 * 除法类
 * auther lijie  2019/5/5.
 */
public class OperationDiv extends Operation{

    @Override
    public double getResult(){

        if(numberB == 0){
            throw new RuntimeException("除数不能为 0 ");
        }

        double result = 0;
        result = numberA / numberB;
        return result;
    }

}