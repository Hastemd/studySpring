package basic.arithmetic;

/**
 * 插入排序
 * auther lijie  2018/10/27.
 *
 * 优化代码可以参考链接 : https://blog.csdn.net/u012152619/article/details/47306209
 *
 */
public class InsertionSort {

    private int [] array;

    public InsertionSort(int [] array){
        this.array = array;
    }

    //按顺序打印数组中的元素
    public void display(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+"\t");
        }
        System.out.println();
    }


    //插入排序
    public void insertionSort(){

        int len = array.length;
        int counter = 1;

        for(int i=1;i<len;i++){

            int temp = array[i];  //存储待排序的元素值
            int insertPoint = i-1;  //与待排序元素值作比较的元素的下标

            while(insertPoint>=0 && array[insertPoint]>temp){ //当前元素比待排序元素大
                array[insertPoint+1]= array[insertPoint];  //当前元素后移一位
                insertPoint--;
            }
            array[insertPoint+1]= temp;  //找到了插入位置，插入待排序元素

            System.out.print("第"+counter+"轮排序结果：");
            display();
            counter++;
        }
    }



}