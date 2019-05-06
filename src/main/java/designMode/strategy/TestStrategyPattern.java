package designMode.strategy;

/**
 * auther lijie  2019/5/6.
 */
public class TestStrategyPattern {

    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.executeStrategy(10,5));

        context = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context.executeStrategy(10,5));

        context = new Context(new OperationMutiply());
        System.out.println("10 * 5 = " + context.executeStrategy(10,5));
    }

}