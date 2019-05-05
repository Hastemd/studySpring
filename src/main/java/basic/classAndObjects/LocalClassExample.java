package basic.classAndObjects;

/**
 * 局部类是在一个块中定义的类，它是一组位于平衡大括号之间的零个或多个语句。
 * 您通常会在方法主体中找到定义的本地类。
 * auther lijie  2019/4/25.
 *
 */
public class LocalClassExample {

    static String regularExpression = "[^0-9]";

    public static void validatePhoneNumber(String phoneNumber1 , String phoneNumber2){
        final int numberLength = 10;

        class PhoneNumber{
            String formattedPhoneNumber = null;

            PhoneNumber(String phoneNumber){
                String currentNumber = phoneNumber.replaceAll(regularExpression,"");
                if(currentNumber.length() == numberLength){
                    formattedPhoneNumber = currentNumber;
                }else{
                    formattedPhoneNumber = null;
                }
            }

            public String getNumber(){
                return formattedPhoneNumber;
            }

        }

        PhoneNumber myNumber1 = new PhoneNumber(phoneNumber1);
        PhoneNumber myNumber2 = new PhoneNumber(phoneNumber2);

        if(myNumber1.getNumber() == null){
            System.out.println("First number is invalid");
        }else{
            System.out.println("First number is " + myNumber1.getNumber());
        }

        if(myNumber2.getNumber() == null){
            System.out.println("Second number is invalid");
        }else{
            System.out.println("Second number is " + myNumber2.getNumber());
        }

    }

    public static void main(String[] args) {
        //validatePhoneNumber("123-456-7890", "456-7890");

        String s1 = "123.12312---3.12313.111".replaceAll(regularExpression, "");
        System.out.println(s1);
    }

}