package designMode.Singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
public enum EnumSingleton {

    INSTANCE;
    public EnumSingleton getInstance(){
        return INSTANCE;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        EnumSingleton singleton1 = EnumSingleton.INSTANCE;
        EnumSingleton singleton2 = EnumSingleton.INSTANCE;
        System.out.println("正常情况下，实例化两个实例是否相同："+(singleton1==singleton2));

        /*
        * NoSuchMethodException
        * 会发现并没有我们所设置的无参构造器，只有一个参数为（String.class,int.class）构造器，然后看下Enum源码就明白，这两个参数是name和ordial两个属性
        * */
        //Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor();

        /*
        * IllegalArgumentException: Cannot reflectively create enum objects
        * */
        Constructor<EnumSingleton> constructor = EnumSingleton.class.getDeclaredConstructor(String.class,int.class);
        constructor.setAccessible(true);
        EnumSingleton singleton3 = constructor.newInstance();
        System.out.println(singleton1);
        System.out.println(singleton2);
        System.out.println(singleton3);
        System.out.println("通过反射攻击单例模式情况下，实例化两个实例是否相同："+(singleton1==singleton3));
    }

}