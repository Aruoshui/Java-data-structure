package 栈.链式栈;

public class test {
    public static void main(String[] args) {
        LinkedStack stack =new LinkedStack();
        System.out.println(stack.isEmpty());
        System.out.println(stack.size());

        System.out.println("**********************");

        stack.push("栈底");
        stack.push("栈的第二个元素");
        System.out.println(stack.size());

        System.out.println("**********************");
        System.out.println(stack.peek());

        System.out.println("**********************");
        stack.push("栈的第三个元素");
        stack.push("栈的第四个元素");
        System.out.println(stack.pop());
        System.out.println(stack.size());

    }
}
