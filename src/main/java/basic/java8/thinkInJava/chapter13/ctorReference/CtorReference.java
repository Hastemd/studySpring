package basic.java8.thinkInJava.chapter13.ctorReference;

import lombok.Data;

/**
 * Dog 有三个构造函数，函数接口内的 make() 方法反映了构造函数参数列表（ make() 方法名称可以不同）。
 * 注意我们如何对 [1]，[2] 和 [3] 中的每一个使用 Dog :: new。
 * 这 3 个构造函数只有一个相同名称：:: new，但在每种情况下都赋值给不同的接口。
 * 编译器可以检测并知道从哪个构造函数引用。
 * 编译器能识别并调用你的构造函数（ 在本例中为 make()）
 * auther lijie  2019/8/13.
 */
public class CtorReference {
    public static void main(String[] args) {
        MakeNoArgs mna = Dog::new; // [1]
        Make1Arg m1a = Dog::new;   // [2]
        Make2Args m2a = Dog::new;  // [3]

        Dog dn = mna.make();
        Dog d1 = m1a.make("Comet");
        Dog d2 = m2a.make("Ralph", 4);
        System.out.println(dn);
        System.out.println(d1);
        System.out.println(d2);
    }
}

@Data
class Dog {
    String name;
    int age = -1; // For "unknown"
    Dog() { name = "stray"; }
    Dog(String nm) { name = nm; }
    Dog(String nm, int yrs) { name = nm; age = yrs; }
}

interface MakeNoArgs {
    Dog make();
}

interface Make1Arg {
    Dog make(String nm);
}

interface Make2Args {
    Dog make(String nm, int age);
}

