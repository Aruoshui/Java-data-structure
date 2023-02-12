package 二叉树;

public class BinaryNode<T> {
    public T date ;
    public BinaryNode<T> left,right;

    public BinaryNode(T date, BinaryNode<T> left, BinaryNode<T> right) {
        this.date = date;
        this.left = left;
        this.right = right;
    }

    public BinaryNode(T date) {
        this.date = date;
    }

}
