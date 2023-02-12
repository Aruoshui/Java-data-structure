package 队列.链式队列;

import 队列.QQueue;


public class LinkedQueue<T> implements QQueue<T> {
    private Node<T> head,tail;

    public LinkedQueue() {   //创建一个空队列
        this.head = null;
        this.tail = null;
    }

    @Override
    public boolean isEmpty() {
        if(head==null&&tail==null){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public void add(T x) {
        if(x!=null) {
           Node<T> newNode =new Node<>(x,null);
           if(head==null){                       //如果头指针指向不为空，则在队头添加
               head=newNode;
           }else{
               this.tail.next=newNode;
           }
           tail=newNode; //让newNode成为新的尾结点

        }
    }

    @Override
    public T poll() {
        if(isEmpty()){
            return null;
        }else {
            T old =this.head.date;
            head=head.next;
            if(head==null)//防止出队后造成tail指针异常
                tail=null;
            return old;

        }


    }

    @Override
    public T peek() {
        if(isEmpty())return null;
        return head.date;
    }
}
