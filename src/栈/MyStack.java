package 栈;

public interface MyStack<T> {
    boolean isEmpty();
    void push(T x);    //入栈
    T pop();              //出栈
    T peek();             //获取栈顶元素

    int size();

}
