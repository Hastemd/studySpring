package designMode.adapterPattern.tfCard;

import designMode.adapterPattern.SDCard;

public class SDAdapterTF implements SDCard {
    private TFCard tfCard;    
    public SDAdapterTF(TFCard tfCard) {        
        this.tfCard = tfCard;    
    }    
    @Override    
    public String readSD() {        
        System.out.println("adapter read tf card ");
        //TODO 这里好像桥接啊!!!
        return tfCard.readTF();    
    }    
    @Override    
    public int writeSD(String msg) {        
        System.out.println("adapter write tf card");        
        return tfCard.writeTF(msg);    
    }
}