package 链表.单链表;

public class MySingleLinkedList<T> implements MySingleListInterface<T>{
    public Node<T> head;                         //建立一个头指针


    public MySingleLinkedList(Node<T> head) {     //链表的构造函数
        this.head = new Node<>(null,null);                 //创建头结点，它的date和next均为空
    }
    @Override
    public boolean isEmpty() {
        return head.next == null;                 //如果头指针未指向下一结点，则表示链表为空
    }

    @Override
    public Node<T> circle() {
        Node<T> pre =this.head;                   //将要插入的结点前的结点与头结点先相连,用于后边遍历
        while (pre.next!=null){
            pre=pre.next;
        }
        return pre;
    }

    @Override
    public Node<T> circle(int i) {
        Node<T> pre = this.head;                   //将要插入的结点前的结点与头结点先相连，找到头后接着next就能找到合适的位置
        for(int j=0;j<i&&pre.next!=null;j++){                     //找到位置i
            pre=pre.next;
        }
        return pre;
    }

    @Override
    public int size() {
        int length=0;                             //单链表的计数器
        Node<T> count =this.head.next;            //找到单链表的第一个元素(头指针指向的即为第一个元素)
        while (count!=null){
            count=count.next;                     //找下一个元素
            length++;
        }
        return length;
    }

    @Override
    public void add(T x) {
        add(0,x);
        /*
        if(x==null)return;                        //不能插入空元素
        Node<T> now =new Node<>(x);               //新建一个结点，date=x,作为要插入的结点。
        circle().next=now;                        //使用circle遍历找到最后一个元素，在此元素末尾插入新元素
        */


    }

    @Override
    public void add(int i, T x) {
        if (x == null) return;
        Node<T> now = new Node<>(x);               //将要插入的数据设为一个新的结点
        now.next=circle(i).next;
        circle().next=now;
        /*
        if (x == null) return;
        Node<T> pre = this.head;                   //将要插入的结点前的结点与头结点先相连，找到头后接着next就能找到合适的位置
        Node<T> now = new Node<>(x);               //将要插入的数据设为一个新的结点
        for(int j=0;j<i&&pre.next!=null;j++){                     //找到要插入的位置i
            pre=pre.next;
        }
        now.next=pre.next;                         //将新元素与pre后的一个元素相连，保证链能找到头，不至于丢失
        pre.next=now;                              //将新元素与pre相连

        /*
        if (x == null) return;
        Node<T> pre = this.head;                   //将要插入的结点前的结点与头结点先相连，找到头后接着next就能找到合适的位置
        Node<T> now = new Node<>(x);               //将要插入的数据设为一个新的结点
        for(int j=0;j<i;j++){                     //找到要插入的位置i
            pre=pre.next;
        }
        now.next=pre.next;                         //将新元素与pre后的一个元素相连，保证链能找到头，不至于丢失
        pre.next=now;                              //将新元素与pre相连

         */
    }


    @Override
    public T get(int i) {
        return circle(i).next.date;              //获得i位置的元素
    }

    @Override
    public void clear() {
        this.head.next=null;
    }



    @Override
    public void set(int i, T x) {
        Node<T> now =new Node<>(x);
        circle(i).next.date=x;

    }


    @Override
    public T remove(int i) {
        if(i>=0){
            if(circle(i).next!=null){
                T old =circle(i).next.date;
                circle(i).next=circle(i).next.next;
                return old;
            }
        }
        return null;
    }


    public void remove(T x){
        this.remove(this.indexof(x));
    }

    @Override
    public int indexof(T x) {
       if(x==null) throw new RuntimeException();

       Node<T> p= this.head.next;
        for(int i=0;i<size();i++){

            if(p.date.equals(x)){
                return i;
            }
            p=p.next;

        }

        return -1;
    }


    @Override
    public void sort() {

    }

    @Override
    public void reverse() {
        if(head==null||head.next==null||head.next.next==null){
            return;
        }
        Node p=head.next;
        head.next=null;
        while(p!=null){
            Node q=p.next;
            p.next=head.next;
            head.next=p;
            p=q;    //p,q往后挪一
        }

    }


}
