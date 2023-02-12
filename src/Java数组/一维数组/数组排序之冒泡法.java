package Java数组.一维数组;

import java.util.Arrays;
import java.util.ArrayList;



public class 数组排序之冒泡法 {
    ArrayList array = new ArrayList();

    public static void main(String[] args) {
        int array[]={1,2,5,8,9,6};
        System.out.println(Arrays.toString(bubbleSort(array)));
    }
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只需要比到这里为止
        int sortBorder = arr.length - 1;

        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSorted  = true;//有序标记，每一轮的初始是true
            for (int j = 0; j < sortBorder; j++) {
                if (arr[j + 1] < arr[j]) {
                    isSorted  = false;//有元素交换，所以不是有序，标记变为false
                    int t = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = t;
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            //一趟下来是否发生位置交换，如果没有交换直接跳出大循环
            if(isSorted )
                break;
        }
        return arr;
    }

}


