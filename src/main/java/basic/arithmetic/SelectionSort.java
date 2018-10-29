package basic.arithmetic;

/**选择排序
 *
 * auther lijie  2018/10/27.
 *
 * 选择排序可以避免这种耗费时间的交换操作，
 * 从第一个元素开始，扫描整个待排数组，找到最小的元素放之后再与第一个元素交换位置，
 * 然后再从第二个元素开始，继续寻找最小的元素与第二个元素交换位置，依次类推
 *
 * <b>不是原地排序<b/>
 */
public class SelectionSort {

    private int [] array;

    public SelectionSort(int [] array){
        this.array = array;
    }

    //按顺序打印数组中的元素
    public void display(){
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+"\t");
        }
        System.out.println();
    }

    //选择排序
    public void selectionSort(){
        int minPoint;  //存储最小元素的小标
        int len = array.length;
        int temp;
        int counter = 1;

        for(int i=0;i<len-1;i++){

            minPoint= i;
            for(int j=i+1;j<=len-1;j++){  //每完成一轮排序，就确定了一个相对最小元素，下一轮排序只对后面的元素排序
                if(array[j]<array[minPoint]){  //如果待排数组中的某个元素比当前元素小，minPoint指向该元素的下标
                    minPoint= j;
                }
            }

            if(minPoint!=i){  //如果发现了更小的元素，交换位置
                temp= array[i];
                array[i]= array[minPoint];
                array[minPoint]= temp;
            }

            System.out.print("第"+counter+"轮排序结果：");
            display();
            counter++;
        }
    }



}