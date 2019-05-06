package designMode.Singleton;

import java.io.*;

/**
 * auther lijie  2019/5/6.
 */
public class SerSingleton implements Serializable {

    private volatile static SerSingleton uniqueInstance;
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private SerSingleton(){

    }

    public static SerSingleton getInstance(){
        if(uniqueInstance == null){
            synchronized (SerSingleton.class){
                if(uniqueInstance == null){
                    uniqueInstance = new SerSingleton();
                }
            }
        }
        return uniqueInstance;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerSingleton s = SerSingleton.getInstance();
        s.setContent("单例序列化");
        System.out.println("序列化前,读取其中的内容 : " + s.getContent());

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SerSingleton.obj"));
        oos.writeObject(s);
        oos.flush();
        oos.close();

        FileInputStream fileInputStream = new FileInputStream("SerSingleton.obj");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        SerSingleton sRead = (SerSingleton)objectInputStream.readObject();
        fileInputStream.close();

        System.out.println(s);
        System.out.println(sRead);
        System.out.println("序列化后读取其中的内容："+sRead.getContent());
        /*
        任何一个readObject方法，不管是显式的还是默认的，它都会返回一个新建的实例，这个新建的实例不同于该类初始化时创建的实例。
        */
        System.out.println("序列化前后两个是否同一个："+(s==sRead));
    }
}