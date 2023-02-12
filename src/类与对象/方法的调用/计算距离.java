package 类与对象.方法的调用;

import java.util.Scanner;

public class 计算距离 {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        int x=input.nextInt();
        int y=input.nextInt();
        int r=input.nextInt();
        System.out.println("the information of the circle:");
        Circle c=new Circle(x,y,r);
        c.showCircle();
    }
}

class Point{
    int x;
    int y;
    public Point() {}
    public Point(int a,int b) {
        this.x=a;
        this.y=b;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

}
class Circle{
    int radius;
    Point center=new Point();                         //可以在其他类之中创建对象

    public Circle(){}
    public Circle(int a,int b,int radius)
    {
        center.setX(a);
        center.setY(b);
        this.radius=radius;
    }

    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void showCenter(){
        System.out.println("center: x="+center.getX()+" y="+center.getY());
    }

    public void showCircle(){
        showCenter();
        System.out.println("radius= "+getRadius());
    }

}
