package 队列.链式队列;

public class test {
    public static void main(String[] args) {
        LinkedQueue list =new LinkedQueue();
        System.out.println(list.isEmpty());
        list.add("一号");
        list.add("二号");
        list.add("三号");
        System.out.println(list.isEmpty());
        System.out.println(list.poll());
        System.out.println(list.peek());
    }
}
