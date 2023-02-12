package 链表.一元多项式;

public class PolyNode {
    private int a;
    private int i;
    PolyNode next;
    public PolyNode(int a,int i){   //创建带有两个数据域的链表结点
        this.a=a;
        this.i=i;
        this.next=null;
    }
    public PolyNode(){
        this(0,0);
    }
    public int getA() {     //系数
        return a;
    }
    public int getI() {     //次幂
        return i;
    }
    public void setA(int a) {
        this.a = a;
    }
    public void setI(int i) {
        this.i = i;
    }
}