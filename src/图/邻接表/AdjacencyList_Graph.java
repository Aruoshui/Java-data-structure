package 图.邻接表;


import 图.Graph;
import 稀疏数组.三元组.Triple;
import 稀疏数组.稀疏矩阵行的单链表.LinkedMatrix;
import 链表.单链表.MySingleLinked_SortedList;
import 链表.单链表.Node;

public class AdjacencyList_Graph<T> extends Graph<T> {

    public LinkedMatrix linkedMatrix;

    public AdjacencyList_Graph(){
        super();
        this.linkedMatrix = new LinkedMatrix(0,0,null);
    }



    public AdjacencyList_Graph(T[] vertexes , Triple[] edges){
        super(vertexes);
        this.linkedMatrix = new LinkedMatrix(vertexes.length,vertexes.length,edges);
        /*
        for (int i = 0; i < edges.length; i++) {
            linkedMatrix.set(edges[i]);
        }
        */
    }


    public int insert(T x){       //插入顶点
        this.GraphVertexList.add(x);
        System.out.println("插入顶点成功");
        return this.GraphVertexList.size()-1;
    }

    public void insert(int i,int j,int w){   //按i，j，w插入
        if(i!=j){
            if(w<0||w>=MAX_WEIGHT){
                w=0;
            }
            this.linkedMatrix.set(i,j,w);
        }
    }

    public void insert(Triple triple){      //按照三元组插入
        this.insert(triple.getRow(),triple.getColume(),triple.getValue());
    }

    public void remove(int i,int j){
        this.linkedMatrix.set(new Triple(i,j,0));
    }

    public void remove(Triple triple){
        this.remove(triple.getRow(),triple.getColume());
    }

    public T remove(int i){

        int n = this.GraphVertexList.size();
        if(i>0 && i<n){

            T x =this.GraphVertexList.get(n-1);
            this.GraphVertexList.set(i,x);       //将删除的第i个顶点用最后一个顶点替换
            x = this.GraphVertexList.remove(n-1);

            MySingleLinked_SortedList link = this.linkedMatrix.rowlist.get(i);
            link.remove(i);
            for(Node<Triple> p = link.head.next; p!=null; p=p.next){     //从要删除的那个顶点对应的单链表开始，
                this.remove(p.date.toSymmetry());
            }

            link = this.linkedMatrix.rowlist.get(n-1);
            for(Node<Triple> p =link.head.next ; p!=null ; p=p.next){
                Triple edge = p.date.toSymmetry();
                this.remove(edge);
                edge.setColume(i);
                this.insert(edge);
                p.date.setRow(i);
            }

            this.linkedMatrix.rowlist.set(i,this.linkedMatrix.rowlist.get(n-1));
            this.linkedMatrix.rowlist.remove(n-1);
            this.linkedMatrix.setRows(n-1);
            this.linkedMatrix.setColumns(n-1);

            return x;


/*
            //删除顶点关联的边
            MySingleLinked_SortedList link = this.linkedMatrix.rowlist.get(i);
            link.remove(i);
            for(Node<Triple> p = link.head.next; p!=null; p=p.next){     //从要删除的那个顶点对应的单链表开始，
                if(p.date.getRow()==i || p.date.getColume()==i){

                }

            }
            //删除顶点
            this.GraphVertexList.remove(i);
            for (int j = i; j < n ; j++) {
                this.GraphVertexList.set(j,this.GraphVertexList.get(i+1));   //删除的元素后边的元素往前移
            }
*/

        }

        return null;
    }



}
