package basic.classAndObjects;

/**
 * 匿名类
 * auther lijie  2019/4/25.
 */
public class HelloWorldAnonymousClasses {

    interface HelloWorld{
        public void greet();
        public void greetSomeone(String someone);
    }

    public void sayHello(){
        class EnglishGreeting implements HelloWorld{
            String name = "world";
            @Override
            public void greet() {
                greetSomeone("world");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hello " + name);
            }
        }
        HelloWorld englishGreeting = new EnglishGreeting();

        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "world";
            @Override
            public void greet() {
                greetSomeone("tout le monde");
            }

            @Override
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };

        HelloWorld spanishGreeting = new HelloWorld() {
            String name = "world";
            public void greet() {
                greetSomeone("mundo");
            }
            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Hola, " + name);
            }
        };


        englishGreeting.greetSomeone("iris");
        frenchGreeting.greet();
        spanishGreeting.greet();
    }

    public static void main(String[] args) {
        HelloWorldAnonymousClasses myAnonymous = new HelloWorldAnonymousClasses();
        myAnonymous.sayHello();
    }

}