package 队列;

public interface QQueue<T> {
    boolean isEmpty();
    void add(T x);
    T poll();
    T peek();
}
