package 链表.单链表;

public interface MySingleListInterface<T>{
    boolean isEmpty();  //判断单链表是否为空
    int size();         //单链表的长度
    T get(int i);       //获取第i个元素
    void set(int i, T x);//修改第i个元素为T类型的x
    void add(int i, T x) ;//插入x作为第i号元素
    void add(T x);       //在线性表末尾插入元素
    T remove(int i);     //将第i号元素清除,并返回此元素
    void clear();       //清除单链表
    int indexof(T x);        //查找位置索引值为x的元素索引
    void sort();        //单链表排序
    void reverse();     //逆转单链表
    Node<T> circle();      //遍历
    Node<T> circle(int i); //遍历到i个元素

}
