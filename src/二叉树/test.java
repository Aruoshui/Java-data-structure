package 二叉树;

public class test {
    public static void main(String[] args) {
        String[] First_root_traversal_order = {
                "A","B","C",
                null,null,"D",
                "E",null,"G",
                null,null,"F",
                null,null,null};
        //A B C # # D E # G # # F # # #

        BinaryTree<String> binaryTree = new BinaryTree<String>(First_root_traversal_order);

        System.out.println("按照递归进行的先根遍历二叉树:");
        binaryTree.preorder(binaryTree.root);
        System.out.println("\n按照非递归进行的先根遍历二叉树");
        binaryTree.preorder_non_recursive();

        System.out.println("\n\n中根遍历二叉树:");
        binaryTree.inorder(binaryTree.root);
        System.out.println("\n按照非递归进行的中根遍历二叉树");
        binaryTree.inorder_non_recursive();

        System.out.println("\n\n后根遍历二叉树:");
        binaryTree.postorder(binaryTree.root);
        System.out.println("\n按照非递归进行的后根遍历二叉树");
        binaryTree.postorder_non_recursive();


        System.out.println("\n树的高为："+binaryTree.height());
        System.out.println("树的叶子数为："+binaryTree.LeafNumber());




    }

}
