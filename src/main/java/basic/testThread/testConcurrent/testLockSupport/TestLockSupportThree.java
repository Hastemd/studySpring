package basic.testThread.testConcurrent.testLockSupport;

import java.util.concurrent.locks.LockSupport;

import static org.apache.commons.codec.digest.DigestUtils.md5Hex;

/**
 * auther lijie  2018/8/10.
 */
public class TestLockSupportThree {

    public void testLockSupportThree(){
        LockSupport.park(this);
    }

    public static void main(String[] args) {
        //TestLockSupportThree testLockSupportThree = new TestLockSupportThree();
        //testLockSupportThree.testLockSupportThree();

        String tel = "18261613632";
        String salt = "307";

        String result = md5Hex(tel + salt);
        System.out.println("md5加盐: " + result);

        System.out.println("开始解密!");



    }
}