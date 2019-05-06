package designMode.adapterPattern.tfCard;

import designMode.adapterPattern.Computer;
import designMode.adapterPattern.MacComputer;
import designMode.adapterPattern.SDCard;
import designMode.adapterPattern.SDCardImpl;

/**
 * auther lijie  2019/5/6.
 */
public class TestAdapter {

    public static void main(String[] args) {
        Computer computer = new MacComputer();
        SDCard sdCard = new SDCardImpl();
        System.out.println(computer.readSD(sdCard));
        System.out.println("====================================");
        TFCard tfCard = new TFCardImpl();
        SDCard tfCardAdapterSD = new SDAdapterTF(tfCard);
        System.out.println(computer.readSD(tfCardAdapterSD));
    }

}