package basic.testThread;

import java.util.Random;

/**
 * Random伪随机性
 * auther lijie  2018/11/1.
 */
public class RandomTest {

    public static void main(String[] args) {

        ////(1)创建一个默认种子的随机数生成器
        //final Random random = new Random();
        ////(2)输出10个在0-5（包含0，不包含5）之间的随机数
        //for (int i = 0; i < 10; ++i) {
        //    System.out.println(random.nextInt(5));
        //}

        Random random = new Random(10);
        System.out.println(random.nextInt()); //0.73043025
        System.out.println(random.nextInt());//第一次打印结果为1913984760
        System.out.println(random.nextInt()); //第二次打印结果为1107254586
        System.out.println("---------------------------------");
        Random random2 = new Random(10);
        System.out.println(random2.nextInt());//-1157793070
        System.out.println(random2.nextInt()); //1913984760
        System.out.println(random2.nextInt()); //0.25780278

    }

}