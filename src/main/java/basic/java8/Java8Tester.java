package basic.java8;

import java.util.stream.Stream;

public class Java8Tester {
 
   final static String salutation = "Hello! ";
   
   public static void main(String args[]){
      GreetingService greetService1 =
              message -> System.out.println(salutation + message);
      greetService1.sayMessage("Runoob");

      Stream.iterate(1, n -> n + 2).limit(10).forEach(System.out::println);

   }
    
   interface GreetingService {
      void sayMessage(String message);
   }
}