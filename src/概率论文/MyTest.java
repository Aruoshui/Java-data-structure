package 概率论文;
import java.util.Random;
public class MyTest {
    public static void main(String[] args) {
        int number = 100000;
        int tag = 1;
        Random r = new Random();
        double flag = 0.36;
        int i = 0;
        int j = 0;
        while (number>0){
            j++;
            if((double)r.nextInt(100)/100<flag){
                i++;
                flag = 0.36;
            }else {
                flag+=0.2;
            }
            number--;
        }
        System.out.println("总共"+j+"轮平A"+"\n触发了"+i+"次"+"\n概率为"+(double)i/j);
    }
}
