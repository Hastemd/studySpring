package designMode.adapterPattern.tfCard;

public interface TFCard {
    String readTF();    
    int writeTF(String msg);
}