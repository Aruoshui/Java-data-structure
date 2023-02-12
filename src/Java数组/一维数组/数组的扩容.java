package Java数组.一维数组;
import java.util.Arrays;
public class 数组的扩容 {
    public static void main(String[] args){
        int[] arr={1,2,3,4,5};
        //调用copyOf方法,返回值是数组的首地址,然后赋值给原数组

        arr=Arrays.copyOf(arr,arr.length*2);

        int arr1[]={6,7,8,9,10};

        System.arraycopy(arr1,0,arr,5,5);

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}
