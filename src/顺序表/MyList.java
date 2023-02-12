package 顺序表;

public class MyList<T> implements MyListInterface<T>{

    protected Object[] value;      //使用protected修饰的成员，在继承子类中仍然时protected，仍然可以被访问，但是外界不能对其随意访问,保护了List内的元素
    protected int length;

    public MyList() {                  //MyList的无参构造
        this.value = new Object[100];  //不指定长度构造顺序表时，默认构造一个100长的
        this.length = 0;               //初始化顺序表的元素个数为0
    }

    public MyList(int size){            //MyList指定长度的构造
        this.value = new Object[size];  //指定长度size构造顺序表
        this.length = 0;               //初始化顺序表的元素个数为0
    }

    public void check(){
        if (value == null) {    //表不能为空否则抛出异常
            throw new RuntimeException();
        }
        if (value.length == 0) {    //表的容量不能为0
            throw new RuntimeException();
        }
        if (length < 0) {    //元素个数不能小于0
            throw new RuntimeException();
        }
        if (length > value.length) {    //元素个数不能大于容量
            throw new RuntimeException();
        }
    }
    protected void check(int i){

        if(i<0||i>this.length){         //添加的元素不能越界
            throw new RuntimeException();
        }
    }


    @Override
    public void add(int i, T x) {
        if( x==null)            //不能插入空对象
            return;
        NeedDilatation();
        check(i);

        for(int j=this.length-1;j>=i;j--){  //将i后的元素后移，从末尾元素开始移动
            this.value[j+1]=this.value[j];
        }

        this.value[i] =x;
        this.length++;

    }

    @Override
    public T get(int i) {
        check(i);                     //检查顺序表是否合法
        return (T)this.value[i];
    }

    @Override
    public void add(T x) {
        if(this.length==0){
            add(0,x);
        }else{
            add(this.length,x);   //默认添加到末尾
        }

    }

    protected void NeedDilatation(){                                   //是否需要扩容方法
        if (this.length==value.length){
            Object[] OtherValue = new Object[value.length*2];       //默认扩为原长的两倍
            for(int i=0;i< value.length;i++){
                OtherValue[i]=value[i];                             //克隆原数组
            }
            this.value=OtherValue;
        }
    }

    @Override
    public boolean isEmpty() {
       if(this.length==0){
           return true;                     //如果长度为0，则代表顺序表为空
       }else
           check();                        //检查顺序表是否合格
           return false;
    }

    @Override
    public int size() {
        return this.length;                 //返回数组的长度
    }

    @Override
    public void clear() {
        this.length=0;                       //设置顺序表长度为0，但是并未释放数组的空间，如果在清除数据后还想在此顺序表中添加信息，就不用重新分配数组空间。
    }


    @Override
    public void set(int i, T x) {
        check(i);                            //检查顺序表是否合法
        if(i>=0&&i<this.length)
            this.value[i]=x;
    }



    @Override
    public T remove(int i) {
        if (this.length==0||i> value.length||i<0){
            return null;
        }
        T value = get(i);                     //记录下删除的元素
        for(int j=i;j<length-1;j++){
            this.value[j]=this.value[j+1];    //在i后边的数据往前移
        }
        this.value[this.length-1]=null;       //将空出来的length-1的元素设置为空
        this.length--;
        return value;                         //返回删除的这个元素
    }

    @Override
    public int indexof(T x) {
        for (int i=0;i<this.length;i++){
            if(x.equals(this.value[i])){
                return i;
            }
        }


        return 0;
    }

    @Override
    public void sort() {
        Object temp;
        for(int i=0;i<length;i++)	{
            for(int j=i+1;j<length;j++) {
                if((int)value[i]>= (int)value[j]) {

                    temp=value[i];
                    value[i]=value[j];
                    value[j]=temp;
                }
            }
        }



    }



}
