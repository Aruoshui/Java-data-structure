package Java数组.二维数组;
import java.util.Scanner;
public class 二维数组基础 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        int[][] arr= new int[5][5];
        System.out.println(arr.length);       //在二维数组中输出共有几行
        System.out.println(arr[0].length);    //在0行中输出有几列

        //初始化一个二维数组
        System.out.println("输入一个"+arr.length+"行和"+arr[0].length+"列的二维数组");
        for(int row=0;row< arr.length;row++){                      //row是行
            for(int column=0;column<arr[0].length;column++){       //column是列
                arr[row][column]=in.nextInt();
            }
        }




    }
}
