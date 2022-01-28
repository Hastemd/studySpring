package basic.javaCollection;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 优先级队列, 是通过数组来实现的小顶堆
 *
 * @author lijie
 * @date 2022/1/28 3:47 下午
 */
@Slf4j
public class PriorityQueueTest {

    public static void main(String[] args) {
        testMinHeap();
        testMaxHead();
    }

    private static void testMaxHead() {
        PriorityQueue<Integer> maxHeap1 = new PriorityQueue<>(11,new Comparator<Integer>(){ //大顶堆，容量11
            @Override
            public int compare(Integer i1,Integer i2){
                return i2-i1;
            }
        });
        //大顶堆，容量11
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, (Integer i1,Integer i2) ->
                i2 - i1
        );
        maxHeap.add(8);
        maxHeap.add(7);
        maxHeap.add(6);
        maxHeap.add(5);
        maxHeap.add(4);
        maxHeap.add(3);
        maxHeap.add(2);
        log.info("maxHeap: {}", maxHeap);
        for (int i = 0; i < 10; i++) {
            log.info("获取大顶堆: {}", maxHeap.poll());
        }
    }

    private static void testMinHeap() {
        //小顶堆，默认容量为11
        //PriorityQueue<Integer> minHeap = new PriorityQueue<>(6);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(11, Comparator.comparingInt((Integer i) -> i)
        );
        minHeap.add(1);
        minHeap.add(8);
        minHeap.add(7);
        minHeap.add(6);
        minHeap.add(5);
        minHeap.add(4);
        minHeap.add(3);
        minHeap.add(2);
        log.info("minHeap: {}", minHeap);
        for (int i = 0; i < 10; i++) {
            log.info("获取小顶堆: {}", minHeap.poll());
        }

    }
}
