package 队列.链式队列;

public class Node<T> {
    public T date;
    public Node<T> next;

    public Node() {
        this(null,null);
    }

    public Node(T date){
        this(date,null);
    }

    public Node(T date, Node<T> next) {
        this.date = date;
        this.next = next;
    }

}
