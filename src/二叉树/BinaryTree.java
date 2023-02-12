package 二叉树;

import 栈.链式栈.LinkedStack;

public class BinaryTree<T> {
    public BinaryNode<T> root;

    //二叉链表树的构造方法
    public BinaryTree(BinaryNode<T> root) {   //根据结点构造二叉树
        this.root = null;
    }

    public BinaryTree(T[] First_root_traversal_order){
        this.root = create(First_root_traversal_order);
    }

    public boolean isEmpty(){
        return this.root == null ;
    }

    public void insert(T x){
        if(x!=null){
            this.root = new BinaryNode<T>(x,this.root,null);    //原根节点作为左孩子
        }
    }

    public BinaryNode<T> insert(BinaryNode<T> p , boolean left , T x){
        if(x==null || p== null){
            return null;
        }
        if(left){
            return p.left = new BinaryNode<T>(x,p.left,null);       //插入左孩子
        }else {
            return p.right = new BinaryNode<T>(x,null,p.right);      //插入右孩子
        }
    }

    public void remove(BinaryNode<T> p , Boolean left){     //删除左/右子树，且只能删除子树。
        if(p!=null){
            if(left){
                p.left = null;
            }else {
                p.right = null;
            }
        }
    }

    public  void clear(){
        this.root = null;
    }


    int i = 0;

    public BinaryNode<T> create(T[] First_root_traversal_order){    //根左右先根遍历添加
        BinaryNode<T> p = null;
        if(i< First_root_traversal_order.length){
            T element = First_root_traversal_order[i];
            i++;
            if(element!= null){
                p = new BinaryNode<T>(element);
                p.left = create(First_root_traversal_order);
                p.right = create(First_root_traversal_order);
            }

        }
        return p;
    }



    //二叉链表树的遍历操作,递归遍历方法

    public void preorder(BinaryNode<T> p){  //前序遍历
        if(p!=null){
            System.out.print(p.date.toString()+" ");
            preorder(p.left);
            preorder(p.right);
        }
    }


    public void inorder(BinaryNode<T> p){  //中序遍历
        if(p!=null){
            inorder(p.left);
            System.out.print(p.date.toString()+" ");
            inorder(p.right);
        }
    }

    public void postorder(BinaryNode<T> p){  //后序遍历
        if(p!=null){
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.date.toString()+" ");
        }
    }


    //二叉链表树的遍历操作,非递归遍历方法

    public void preorder_non_recursive(){   //根左右
        LinkedStack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
        BinaryNode<T> currentNode = this.root;                               //建一个指向当前位置的指针
        while (currentNode!=null || !stack.isEmpty()){
            if(currentNode!=null){                      //先找左子树
                System.out.print(currentNode.date.toString()+" ");
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            else {                                      //左子树走完之后找右子树
                currentNode = stack.pop();              //回到上一个
                currentNode =currentNode.right;         //找右
            }
        }
    }


    public void inorder_non_recursive(){
        LinkedStack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
        BinaryNode<T> currentNode = this.root;
        while (currentNode!=null || !stack.isEmpty()){
            if(currentNode!=null){
                //System.out.print(currentNode.date.toString()+" ");
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            else {
                System.out.print(stack.peek().date+" ");         //打印栈顶元素的date
                currentNode = stack.pop();
                currentNode =currentNode.right;
            }
        }
    }


    public void postorder_non_recursive(){
        LinkedStack<BinaryNode<T>> stack = new LinkedStack<BinaryNode<T>>();
        BinaryNode<T> currentNode = this.root;
        StringBuffer str1 = new StringBuffer();
        StringBuffer str2 = new StringBuffer();

        while (currentNode!=null || !stack.isEmpty()){
            if(currentNode!=null){
                str1.append(currentNode.date.toString());
                stack.push(currentNode);
                currentNode =currentNode.right;               //改为先从右子树开始遍历，其他不变
            }
            else {
                currentNode = stack.pop();
                currentNode = currentNode.left;

            }
        }
        str1.reverse();
        for (int j = 0; j < str1.length(); j++) {
            str2.append(str1.charAt(j)+" ");
        }
        System.out.println(str2);
    }


    public int height(){
       return height(root);
    }
    public int height(BinaryNode<T> p) {
        if (p == null) {
            return 0;
        }
        int leftHeight = height(p.left);
        int rightHeight = height(p.right);

        if(leftHeight>rightHeight){
            return leftHeight+1;
        }else {
            return rightHeight+1;
        }
    }


    int LeafNumber = 0;
    public int LeafNumber(){
        return LeafNumber(root);
    }
    public int LeafNumber(BinaryNode<T> p){
        if(p==null){
            return 0;
        }
        LeafNumber(p.left);
        LeafNumber(p.right);

        if(p.left==null&&p.right==null){
            LeafNumber++;
        }

        return LeafNumber;
    }



}
