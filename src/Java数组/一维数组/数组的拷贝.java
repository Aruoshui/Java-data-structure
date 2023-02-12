package Java数组.一维数组.数组的使用.数组的拷贝;

public class 数组的拷贝 {
    public static void main(String[] args) {
        int array1[]={10,20,30};

        //创建一个新的数组，开辟新的数据空间；
        int array2[]=new int[array1.length];

        //遍历array1,把每一个值对应拷贝
        for(int i=0;i< array1.length;i++){
            array2[i]=array1[i];
        }

        //系统方法，数组复制
        System.arraycopy(array1, 0, array2, 0, array1.length);

        /*
           src - 源数组。
           srcPos - 源数组中的起始位置。
           dest - 目标数组。
           destPos - 目标数据中的起始位置。
           length - 要复制的数组元素的数量。
         */




    }
}
