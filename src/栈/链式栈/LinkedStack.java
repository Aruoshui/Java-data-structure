package 栈.链式栈;


import 栈.MyStack;

public class LinkedStack<T> implements MyStack<T> {
    private Node<T> head;
    private int n;

    public LinkedStack() {
        this.head = new Node<>(null,null);  //带头结点
        this.n = 0;
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public void push(T x) {
        Node bottom = head.next;                  //首结点指向第一个结点
        Node newNode=new Node(x,null);    //创立一个新的结点
        head.next=newNode;                     //首结点指向新结点
        newNode.next=bottom;                      //新节点指向第一个结点
        n++;

    }

    @Override
    public T pop() {
        if(head.next==null)return null;
        Node p=head.next;
        head.next=p.next;
        n--;
        return (T) p.date;

    }

    @Override
    public T peek() {
        return head.next.date;
    }

    @Override
    public int size() {
        return n;
    }
}
