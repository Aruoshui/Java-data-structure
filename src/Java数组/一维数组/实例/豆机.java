/*package Java数组.一维数组.实例;
import java.util.Random;
import java.util.Scanner;

public class 豆机 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of balls to drop:");
        int balls_number = in.nextInt();					//定义小球数量
        System.out.print("Enter the number of slots in the bean machine:");
        int slots_number = in.nextInt();					//定义机器槽数
        String[][] track = new String[balls_number][slots_number-1];
        int[] position = new int[balls_number];				//定义数组存储小球最终位置,存储小球右偏次数

        track = trackOfBalls(balls_number,slots_number,position);
        int[] slots = resultOfSlots(slots_number,position);	//slots统计每个槽掉落的小球数
        printTrack(track);
        printOfSlots(balls_number,slots_number,slots);

        in.close();
    }

    //返回0表示左，1表示右
    public static int isLeftOrRight() {
        Random r = new Random();
        return r.nextInt(2);
    }

    //判断小球的下落情况
    public static String[][] trackOfBalls(int balls_number,int slots_number,int[] position){
        String[][] track = new String[balls_number][slots_number-1];	//定义数组存储小球下落轨迹

        for(int i = 0; i < balls_number; i++)					//外循环表示有多少个小球
        {
            for(int j = 0; j < slots_number - 1; j++)			//内循环表示每个小球的下落轨迹
            {
                if(isLeftOrRight() == 0)
                {
                    track[i][j] = "L";
                }
                else
                {
                    track[i][j] = "R";
                    position[i]++;
                }
            }
        }
        return track;
    }

    //输出轨迹
    public static void printTrack(String[][] track) {
        for(int i = 0;i < track.length; i++)
        {
            for(int j =0; j < track[i].length; j++)
            {
                System.out.print(track[i][j]);
            }
            System.out.println();
        }
    }

    //统计每个槽掉落的小球数
    public static int[] resultOfSlots(int slots_number,int[] position) {
        int[] slots = new int[slots_number];		//slots统计每个槽掉落的小球数

        for(int i = 0; i < position.length; i++)
        {
            for(int j= 0; j < slots_number; j++)
            {
                if(j == position[i])
                {
                    slots[j]++;
                    break;
                }
            }
        }
        //for(int i=0;i<slots.length;i++)
        //	System.out.print(slots[i]+" ");
        //System.out.println();
        return slots;
    }

    //输出每个槽中小球的情况
    public static void printOfSlots(int balls_number,int slots_numbers,int[] slots) {
        for(int i = balls_number; i > 0; i--)
        {
            for(int j = 0; j < slots_numbers; j++)
            {
                if(slots[j] < i)
                    System.out.print(" ");
                else
                    System.out.print("O");
            }
            System.out.println();
        }

    }

}
*/
