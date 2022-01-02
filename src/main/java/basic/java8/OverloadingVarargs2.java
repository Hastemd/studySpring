package basic.java8;

public class OverloadingVarargs2 {
    static void f(float i, Character... args) {
        System.out.println("first");
        System.out.println(i);
        System.out.println(args);
    }

    //static void f(Character... args) {
    //    System.out.println("second");
    //}

    public static void main(String[] args) {
        //f(1, 'a');
        f('a', 'b');
    }
}