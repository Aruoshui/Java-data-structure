package 图2.邻接表;

import 稀疏数组.三元组.Triple;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        while (true){
            Scanner in = new Scanner(System.in);
            int choose = in.nextInt();
            switch (choose){
                case 0 :{
                    String[] vertexes = {"A","B","C","D","E"};   //new Triple(0,3,2)
                    Triple[] triple = {
                            new Triple(0,3,2),new Triple(0,1,5),
                            new Triple(1,0,5),new Triple(1,2,7),new Triple(1,3,6),
                            new Triple(2,1,7),new Triple(2,3,8),new Triple(2,4,3),
                            new Triple(3,0,2),new Triple(3,1,6),new Triple(3,2,8),new Triple(3,4,9),
                            new Triple(4,2,3),new Triple(4,3,9)
                    };

                    AdjacencyList_Graph graph = new AdjacencyList_Graph(vertexes,triple);
                    System.out.println(graph.PrintGraph());

                    System.out.println("*********************************");
                    graph.insert_Vertex("F");
                    graph.insert_Edge(new Triple(5,0,10));
                    graph.insert_Edge(new Triple(5,0,5));
                    System.out.println(graph.PrintGraph());

                    System.out.println("*********************************");
                    graph.remove_Vertex("F");
                    System.out.println(graph.PrintGraph());

                    System.out.println("*********************************");
                    graph.remove_Vertex("C");
                   System.out.println(graph.PrintGraph());


                    System.out.println("*********************************");
                    System.out.println("序号"+2+"对应的顶点的邻接顶点为"+graph.NextNeighbor(2,1));

                    System.out.println("*********************************");
                    //graph.DFSTraverse(0);

                    break;
                }

                case 1 :{
                    String[] vertexes = {"A","B","C","D","E","F"};
                    Triple[] triple = {
                            new Triple(0,2,2),new Triple(0,1,1),new Triple(0,3,5),
                            new Triple(2,0,2),new Triple(1,0,1),new Triple(3,0,5),
                            new Triple(3,5,6),new Triple(5,3,6),
                            new Triple(1,4,3),new Triple(4,1,3),
                            new Triple(2,4,4),new Triple(4,2,4),
                    };

                    AdjacencyList_Graph graph = new AdjacencyList_Graph(vertexes,triple);
                    System.out.println(graph.PrintGraph());
                    //System.out.println(graph.NextNeighbor(4,-1));
                    System.out.print("图的深度遍历递归算法:");graph.DFS_Recursion(0,new boolean[graph.vertexNodeList.size()]);
                    System.out.print("\n图的深度遍历非递归算法:");graph.DFS_NonRecursive(0,new boolean[graph.vertexNodeList.size()]);

                    System.out.println("*****************************");

                    System.out.print("图的广度优先算法:");graph.BFS_Queue(0,new boolean[graph.vertexNodeList.size()]);

                    System.out.println("\n*****************************");

                    System.out.println(graph.weight(4,2));
                    System.out.println("\n******************************");

                    graph.minSpanTree();

                }

                case 2 :{
                    System.exit(0);
                }
            }



        }







    }
}
