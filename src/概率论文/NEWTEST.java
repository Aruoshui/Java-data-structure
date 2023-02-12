package 概率论文;

import java.util.Random;

public class NEWTEST {
    public static void main(String[] args) {
        int number = 100000;

        Random r = new Random();
        double flag = 0.36;
        int i = 0;
        int j = 0;
        while (number>0){
            j++;
            int tag = 1;
            //System.out.println("第"+j+"轮平A————————————————————");
            while (tag<8){
                if((double)r.nextInt(100)/100<=flag){
                    i++;
                    //System.out.println("第"+tag+"次触发");
                    flag = 0.36;
                }else {
                    if(tag!=2&&tag!=3&&tag!=4&&tag!=5&&tag!=6&&tag!=7){
                        flag+=0.2;
                    }
                }
                tag++;

            }

            number--;
        }
        System.out.println("总共"+j+"轮平A"+"\n触发了"+i+"次"+"\n概率为"+(double)i/(j*7));
    }

}
