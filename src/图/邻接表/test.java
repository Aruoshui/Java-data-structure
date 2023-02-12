package 图.邻接表;

import 稀疏数组.三元组.Triple;

public class test {
    public static void main(String[] args) {
        String[] vertexes = {"A","B","C","D","E"};   //new Triple(0,3,2)
        Triple[] triple = {
                new Triple(0,3,2),new Triple(0,1,5),
                new Triple(1,0,5),new Triple(1,2,7),new Triple(1,3,6),
                new Triple(2,1,7),new Triple(2,3,8),new Triple(2,4,3),
                new Triple(3,0,2),new Triple(3,1,6),new Triple(3,2,8),new Triple(3,4,9),
                new Triple(4,2,3),new Triple(4,3,9)
        };
        AdjacencyList_Graph graph = new AdjacencyList_Graph(vertexes,triple);    //T[] vertexes , Triple[] edges

        System.out.println(graph.linkedMatrix.rowlist.get(0).get(0));
        System.out.println(graph.linkedMatrix.rowlist.get(0).size());
        System.out.println(graph.linkedMatrix.rowlist.get(0).get(1));
        System.out.println(graph.linkedMatrix.rowlist.get(1).get(1));
        System.out.println(graph.linkedMatrix.rowlist.get(1).size());

        graph.insert(new Triple(0,4,10));

        System.out.println(graph.linkedMatrix.rowlist.get(0).get(2));
        //graph.remove(0);

        graph.remove(new Triple(0,1,5));


        System.out.println("*********************");
        System.out.println(graph.linkedMatrix.rowlist.get(0).get(0));
        System.out.println(graph.linkedMatrix.rowlist.get(0).size());

/*
        System.out.println(graph.toString_Vertex());

        graph.insert("F");  //插入一条边

        System.out.println(graph.toString_Vertex());
*/



    }




}
