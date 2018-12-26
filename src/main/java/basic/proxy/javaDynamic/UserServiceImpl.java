package basic.proxy.javaDynamic;

/**
 * @Description 可知 JDK 动态代理是对接口进行的代理；代理类实现了接口，
 * 并继承了 Proxy 类；目标对象与代理对象没有什么直接关系，
 * 只是它们都实现了接口，
 * 并且代理对象执行方法时候内部最终是委托目标对象执行具体的方法。
 *
 * @Author 李杰 lijie@ane56.com
 * @Date 2018/12/25 2:56 PM
 */
public class UserServiceImpl implements UserServiceBo {

    @Override
    public int add() {
        System.out.println("--------------------add----------------------");
        return 0;
    }


    public static void main(String[] args) {
        //(5)打开这个开关，可以把生成的代理类保存到磁盘
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //(6)创建目标对象（被代理对象）
        UserServiceBo service = new UserServiceImpl();
        //(7)创建一个InvocationHandler实例，并传递被代理对象
        MyInvocationHandler handler = new MyInvocationHandler(service);
        //(8)生成代理类
        UserServiceBo proxy = (UserServiceBo) handler.getProxy();
        proxy.add();
    }
}