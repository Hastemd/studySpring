package designMode.Singleton;

import java.io.*;

/**
 * 相对于 SerSingleton ,
 * 枚举单例的优点是:
 *      1,避免反射攻击
 *      2,避免序列化问题
 *
 * auther lijie  2019/5/6.
 * @see SerSingleton
 * @see Enum
 */
public enum SerEnumSingleton {

    INSTANCE;

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    SerEnumSingleton(){

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        SerEnumSingleton s = SerEnumSingleton.INSTANCE;
        s.setContent("枚举单例序列化");
        System.out.println("枚举序列化前读取其中的内容："+s.getContent());
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("SerEnumSingleton.obj"));
        oos.writeObject(s);
        oos.flush();

        FileInputStream fis = new FileInputStream("SerEnumSingleton.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        SerEnumSingleton s1 = (SerEnumSingleton)ois.readObject();
        ois.close();
        System.out.println(s+"\n"+s1);
        System.out.println("枚举序列化后读取其中的内容："+s1.getContent());
        System.out.println("枚举序列化前后两个是否同一个："+(s==s1));

    }

}