package basic.testThread.advanced;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * auther lijie  2018/11/2.
 */
public class TestUnSafeReflect {

    static final Unsafe unsafe;
    static final long stateOffset;
    private volatile long state = 0;

    static {

        try {
            // 反射获取 Unsafe 的成员变量 theUnsafe（2.2.10）
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            // 设置为可存取（2.2.11）
            field.setAccessible(true);
            // 获取该变量的值（2.2.12）
            unsafe = (Unsafe) field.get(null);
            //获取 state 在 TestUnSafe 中的偏移量 （2.2.13）
            stateOffset = unsafe.objectFieldOffset(TestUnSafe.class.getDeclaredField("state"));
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new Error(ex);
        }
    }

    public static void main(String[] args) {

        TestUnSafeReflect test = new TestUnSafeReflect();
        Boolean sucess = unsafe.compareAndSwapInt(test, stateOffset, 0, 1);
        System.out.println(sucess);

    }

}