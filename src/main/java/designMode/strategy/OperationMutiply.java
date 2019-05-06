package designMode.strategy;

/**
 * auther lijie  2019/5/6.
 */
public class OperationMutiply implements Strategy {

    @Override
    public int doOperation(int number1, int number2) {
        return number1 * number2;
    }
}