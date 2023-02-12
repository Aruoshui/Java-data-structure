package 测试;


import 链表.单链表.Node;



// 定义LinkedStack类
public class LinkedStack {
    private Node top; // 栈顶，指向栈顶元素

    // 构造函数，将top设为null
    public LinkedStack() {
        top = null;
    }

    // 入栈函数
    public void push(Object item) {
        // 创建新的节点
        Node newNode = new Node();
        // 设置新节点的数据域为item参数
        newNode.date = item;
        // 让新节点的指针域指向当前栈顶元素
        newNode.next = top;
        // 将新节点设为当前的栈顶元素
        top = newNode;
    }

    public static void main(String[]args){
        LinkedStack link = new LinkedStack();
        link.push(1);
        System.out.println(link.top.date);
    }

}

// 出栈函数，返回出栈节点的数据域中存储的信息    	    	    	    	    	     	    	        	      	        	         	       	           	            	             	              	                public Object pop(){        if(top == null) return null;       // 若当前栈为空，则返回null       Object item = top . data;           // 获取当前栈顶元素的数据域信息       top = top . next;            // 将当前栈顶指向下一个元素        return item;            // 返回当前栈顶元素的信息   }

// 显示当前栈顶元素的函数，但不弹出该元素      public Object peek(){