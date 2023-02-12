package 顺序表;

public interface MyListInterface<T> {   //线性表接口，使用泛型数据类型T，扩大方法参数的范围
    boolean isEmpty();  //判断顺序表是否为空
    int size();         //顺序表的长度
    T get(int i);       //获取第i个元素
    void set(int i, T x);//修改第i个元素为T类型的x
    void add(int i, T x);//插入x作为第i号元素
    void add(T x);       //在顺序表末尾插入元素
    T remove(int i);     //将第i号元素清除,并返回此元素
    int indexof(T x);        //查找位置索引值为x的元素索引
    void clear();       //清除顺序表
    void sort();          //对顺序表排序
   // void AllClear();    //完全清除顺序表，并将分配的数组空间清除

}
