package 大物实验;

public class 密立根油滴 {
    /*
    #include<stdio.h>
#include<stdlib.h>
#include<math.h>
#define Pi 3.1415926534      //定义圆周率的取值
#define DENSITY 979       //油滴的密度
#define b (6.17e-6)       //粘滞系数修正常数
#define g 9.794           //重力加速度
#define d 5e-3            //极板间距离
#define l (1.5e-3)        //油滴匀速上升或下降的距离
#define p 76              //大气压强
#define e 1.60217733e-19         //元电荷
#define ETA (1.83e-5)     //粘滞系数
int main(){
    float q,U,tg,a,q1,x,te,k,vg,ve,s,y;
	int i,t,n,n2;
	while (2>1)	{
	      printf("平衡法请输入1，动态法请输入2，计算7组数据的平均值请输入3，结束程序请输入其他数字\n");
		  scanf("%d",&t);
		  if (t==1){
		  	printf("请输入平衡电压U和下降时间tg，用空格隔开\n");
			scanf("%f %f",&U,&tg);
			a = sqrt((9*ETA*l)/(2*DENSITY*g*tg));
			k = ((18*Pi*d)/(sqrt(2*DENSITY*g)))*pow((ETA*l)/((1+(b/(p*a)))),1.5);
			vg = l/tg;
			q=k/U*pow((1/tg),1.5);
			q1=q/e;
			n=q1;
			if (q1-n>0.49)
				n++;
			q1=q/n;
			x=abs((q1-e)*10000/e);
			printf("平衡法总电荷值：%e\n电子数：%d\n电子平均电荷值：%e\n下降速度vg: %e\n与元电荷的误差：%3.2f%%\n\n",q,n,q1,vg,x/100);
		}
	else if (t==2){
		printf("请输入提升电压U、下降时间tg和上升时间te，用空格隔开\n");
		scanf("%f %f %f",&U,&tg,&te);
		a = sqrt((9*ETA*l)/(2*DENSITY*g*tg));
		k = ((18*Pi*d)/(sqrt(2*DENSITY*g)))*pow((ETA*l)/((1+(b/(p*a)))),1.5);
		vg = l/tg;
		ve = l/te;
		q=k/U*(1/tg+1/te)*sqrt(1/tg);
		q1=q/e;
		n=q1;
		if(q1-n>0.49)
			n++;
		q1=q/n;
		x=abs((q1-e)*10000/e);
		printf("动态法总电荷值：%e\n电子数：%d\n电子平均电荷值：%e\n下降速度vg: %e\n上升速度ve: %e\n待求值a: %e\n待求值K :%e\n与元电荷的误差：%3.2f%%\n\n",q,n,q1,vg,ve,a,k,x/100);
	}
	else if (t==3){
	    printf("请输入7个数据\n");
		s=0;
		for (i=1;i<=5;i++){
			scanf("%f",&y);
			s+=y;
		}
		s=s/5;
		printf("平均值为： %f\n",s);
	}
	else
		break;
		}
	}

     */
}
