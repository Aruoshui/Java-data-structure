package 概率论文;

public class test{

    public static void main(String[] args) {

        double attack1=0.8789;//荧第一击倍率。

        double attack2=0.8585;//荧第二击倍率。

        double attack3=1.0472;//荧第三击倍率。

        double attack4=1.1526;//荧第四击倍率。

        double attack5=1.3991;//荧第五击倍率。

        int attackn=0;//总攻击次数

        double damagen=0;//总伤害

        double damagebase=0;//基础伤害

        for (int i=0; i<100000000; i++){//开始遍历一亿次。

            if (Math.random()<0.36){
                attackn+=1;damagen+=0.7+attack1;
            }

            else if (Math.random()<0.56){
                attackn+=2;damagen+=0.7+attack1+attack2;
            }

            else if (Math.random()<0.76){
                attackn+=3;damagen+=0.7+attack1+attack2+attack3;
            }

            else if (Math.random()<0.96){
                attackn+=4;damagen+=0.7+attack1+attack2+attack3+attack4;
            }

            else {
                attackn+=5;damagen+=0.7+attack1+attack2+attack3+attack4+attack5;
            }

        }

        damagebase=(attack1+attack2+attack3+attack4+attack5)*attackn*0.2;

        System.out.print("增伤倍率：");

        System.out.print(damagen/damagebase);

        System.out.print("（攻击次数：");

        System.out.print(attackn);

        System.out.print("）");



    }



}