package 链表.单链表;

public class MySingleLinked_SortedList<T extends Comparable> extends MySingleLinkedList{

    public boolean order;

    public MySingleLinked_SortedList(Node head) {
        super(head);
    }

    public void add(T x){
        if(x==null){
            return;
        }

        Node<T> front = this.head , p=front.next;   //带前驱和后继

        while (p!=null &&(this.order ? x.compareTo(p.date)<=0 : x.compareTo(p.date)>=0)){   //asc为真，执行前，
            front = p;
            p= p.next;

        } //找到插入位置

        front.next = new Node<T>(x,p); //插入


    }

}
