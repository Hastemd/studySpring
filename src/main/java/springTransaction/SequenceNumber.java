/**
 * Created by lijie on 2017/10/13.
 */
package springTransaction;

/**
 * auther lijie  2017/10/13.
 * 了解一下ThreadLocal的使用方法
 */
public class SequenceNumber {

    //使用匿名内部类覆盖ThreadLocal的initialValue()方法,指定初始值
    private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>(){
        @Override
        public Integer initialValue(){
            return 0;
        }
    };

    public int getNextNum(){
        seqNum.set(seqNum.get() + 1);
        return seqNum.get();
    }

    public static void main(String[] args) {
        SequenceNumber sn = new SequenceNumber();
        TestClient t1 = new TestClient(sn);
        TestClient t2 = new TestClient(sn);
        TestClient t3 = new TestClient(sn);
        t1.start();
        t2.start();
        t3.start();
    }

    public static class TestClient extends Thread{
        private SequenceNumber sn;

        public TestClient(SequenceNumber sn) {
            this.sn = sn;
        }

        @Override
        public void run(){
            for(int i = 0 ; i < 3 ; i++){
                //每个线程打印3个序列值
                System.out.println("thread[" + Thread.currentThread().getName() + "] sn[" + sn.getNextNum() + "]");
            }
        }
    }
}