package designMode.simpleFactory;

/**
 * auther lijie  2019/5/5.
 */
public class TestOperation {

    public static void main(String[] args) {
        Operation operation = OperationFactory.createOperate("11");
        operation.setNumberA(1);
        operation.setNumberB(2);
        double result = operation.getResult();
        System.out.println(result);
    }
}