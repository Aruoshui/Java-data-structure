package 稀疏数组;

import 稀疏数组.三元组.Triple;
import 稀疏数组.稀疏矩阵行的单链表.LinkedMatrix;

public class text {
    public static void main(String[] args) {
        Triple[] triple = {
                new Triple(0,1,5),new Triple(0,3,2),
                new Triple(1,0,5),new Triple(1,2,7),new Triple(1,3,6),
                new Triple(2,1,7),new Triple(2,3,8),new Triple(2,4,3),
                new Triple(3,0,2),new Triple(3,1,6),new Triple(3,2,8),new Triple(3,4,9),
                new Triple(4,2,3),new Triple(4,3,9)
        };
        LinkedMatrix linkedMatrix = new LinkedMatrix(5,5,triple);
        linkedMatrix.toString();
        //linkedMatrix.printMatrix();
    }
}
