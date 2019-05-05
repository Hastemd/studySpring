package designMode.simpleFactory;

/**
 * 简单运算工厂类
 * auther lijie  2019/5/5.
 */
public class OperationFactory {

    public static Operation createOperate(String operate){
        Operation operation = null;
        switch (operate){
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/":
                operation = new OperationDiv();
                break;
            default:
                operation = new OperationAdd();
        }
        return operation;
    }

}