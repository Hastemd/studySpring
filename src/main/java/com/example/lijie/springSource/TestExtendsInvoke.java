package com.example.lijie.springSource;

/**
 * auther lijie  2018/6/12.
 * java继承,调用一个方法是,应该是就近原则
 * 首先看本类有没有这个发放,没有就找父类,在没有就继续像上层父类查找
 */
public class TestExtendsInvoke extends B{

    @Override
    public void sayHello(){
        System.out.println("TestExtendsInvoke");
    }

    public void sayHi(){
        System.out.println("nihao Test");
    }
    public static void main(String[] args) {
        TestExtendsInvoke testExtendsInvoke = new TestExtendsInvoke();
        testExtendsInvoke.sayHello();
    }

}


class A {
    public void sayHello(){
        System.out.println("hello A");
        sayHi();
    }

    public void sayHi(){
        System.out.println("nihao A");
    }
}

class B extends A{
    @Override
    public void sayHello(){
        System.out.println("hello B");
    }

    public void sayHi(){
        System.out.println("nihao B");
    }
}