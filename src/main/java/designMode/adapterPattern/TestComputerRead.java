package designMode.adapterPattern;

/**
 * auther lijie  2019/5/6.
 */
public class TestComputerRead {

    public static void main(String[] args) {
        Computer computer = new MacComputer();
        SDCard sdCard = new SDCardImpl();
        System.out.println(computer.readSD(sdCard));
    }

}