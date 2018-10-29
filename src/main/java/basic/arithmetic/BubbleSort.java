package basic.arithmetic;

/**
 * 冒泡排序
 * 复杂度为O(N^2)。
 * auther lijie  2018/10/27.
 *
 *
 * <p>冒泡排序中有一个缺点，比如，我们比较第一个数a1与第二个数a2的时候，
 * 只要a1比a2大就会交换位置，但是我们并不能确定a2是最小的元素，
 * 假如后面还有比它更小的，该元素还会与a2再次进行交换，
 * 而且这种交换有可能发生多次才能确定a2的最终位置。<p/>
 */
public class BubbleSort {

    private int [] array;

    public BubbleSort(int [] array){
        this.array = array;
    }

    //按顺序打印数组中的元素
    public void display(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+"\t");
        }
        System.out.println();
    }

    //冒泡排序
    public void bubbleSort(){
        int temp;
        int len = array.length;

        for(int i=0;i<len-1;i++){  //外层循环：每循环一次就确定了一个相对最大元素
            for(int j=1;j<len-i;j++){  //内层循环：有i个元素已经排好，根据i确定本次的比较次数
                if(array[j-1]>array[j]){  //如果前一位大于后一位，交换位置
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;
                }
            }
            System.out.print("第"+(i+1)+"轮排序结果：");
            display();
        }
    }


    //冒泡排序改进1
    public void bubbleSort_improvement_1(){
        int temp;
        int len = array.length;

        for(int i=0;i<len-1;i++){
            boolean exchange = false;  //设置交换变量
            for(int j=1;j<len-i;j++){
                if(array[j-1]>array[j]){  //如果前一位大于后一位，交换位置
                    temp = array[j-1];
                    array[j-1] = array[j];
                    array[j] = temp;

                    if(!exchange) exchange =true;  //发生了交换操作
                }
            }
            System.out.print("第"+(i+1)+"轮排序结果：");
            display();
            if(!exchange) break;  //如果上一轮没有发生交换数据，证明已经是有序的了，结束排序
        }
    }



    //冒泡排序改进2
    public void bubbleSort_improvement_2(){
        int temp;
        int counter = 1;
        int endPoint = array.length-1;  //endPoint代表最后一个需要比较的元素下标

        while(endPoint>0){
            int pos = 1;
            for(int j=1;j<=endPoint;j++){
                if(array[j-1]>array[j]){  //如果前一位大于后一位，交换位置
                    temp= array[j-1];
                    array[j-1]= array[j];
                    array[j]= temp;

                    pos= j;  //下标为j的元素与下标为j-1的元素发生了数据交换
                }
            }
            endPoint= pos-1;  //下一轮排序时只对下标小于pos的元素排序，下标大于等于pos的元素已经排好

            System.out.print("第"+counter+"轮排序结果：");
            counter++;
            display();
        }
    }





    public static void main(String[] args) {
        int[] a = {1, 5, 4, 11, 2, 20, 18};
        BubbleSort sort = new BubbleSort(a);
        System.out.print("未排序时的结果：");
        sort.display();
        sort.bubbleSort_improvement_2();
    }

}