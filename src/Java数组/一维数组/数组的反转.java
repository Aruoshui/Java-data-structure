package Java数组.一维数组;

public class 数组的反转 {
    public static void main(String[] args) {
        int array1[] = {10,20,30,40};

        for(int i=0;i< array1.length/2;i++){
            int temp=array1[array1.length-1-i];
            array1[array1.length-1-i]=array1[i];
            array1[i]=temp;
        }

    }
}
