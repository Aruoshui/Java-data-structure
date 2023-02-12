package 图2.邻接表;

import 栈.MyStack;
import 栈.链式栈.LinkedStack;
import 稀疏数组.三元组.Triple;
import 链表.单链表.MySingleLinked_SortedList;
import 链表.单链表.Node;
import 队列.QQueue;
import 队列.链式队列.LinkedQueue;
import 顺序表.MyList;

import static java.lang.Float.POSITIVE_INFINITY;

public class AdjacencyList_Graph<T>{

    public static final int MAX_WEIGHT = (int) POSITIVE_INFINITY;   //无穷大
    

    public MyList<VertexNode<T>>   vertexNodeList = new MyList<>();   //顶点的顺序表

    public AdjacencyList_Graph(T[] vertexes , Triple[] edges) {     //使用顶点的数组集合和边的数组集合创建图
        for (int i = 0; i < vertexes.length; i++) {
            VertexNode<T> vertex = new VertexNode<>(vertexes[i],new MySingleLinked_SortedList<>(null));
            vertexNodeList.add(i,vertex);
        }
        for (int i = 0; i < edges.length; i++) {
            for(int j =0 ;j< vertexes.length ; j++){
                if(edges[i].getRow()==j){
                    this.vertexNodeList.get(j).rowlist.add(edges[i]);
                }
            }
        }

    }

    public StringBuffer PrintGraph(){
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < vertexNodeList.size(); i++) {
            str.append("顶点"+i+"的数据为"+vertexNodeList.get(i).getDate()+",所对应的边为---->");
            for (int j = 0; j < vertexNodeList.get(i).rowlist.size(); j++) {
                str.append(vertexNodeList.get(i).rowlist.get(j)+",");
            }
            str.append("\n");
        }
        return str;
    }

    public void insert_Vertex(T vertex){
        this.vertexNodeList.add(new VertexNode<T>(vertex,new MySingleLinked_SortedList<>(null)));
    }

    public void insert_Edge(Triple triple){
        int i = triple.getRow();
        int j = triple.getColume();
        int number = this.vertexNodeList.size();
        if(i>=0 && i<number && j>=0 && j<number && i!=j){
            MySingleLinked_SortedList<Triple> list = this.vertexNodeList.get(i).rowlist;
            list.add(triple);
        }
    }

    public void insert(T vertex , Triple triple){
        this.insert_Vertex(vertex);
        this.insert_Edge(triple);
    }


    public void remove_Edge(Triple triple){
        int i = triple.getRow();

        MySingleLinked_SortedList<Triple> list = this.vertexNodeList.get(i).rowlist;
        //System.out.println("++++++++");
/*
        int position = list.indexof(triple);
        System.out.println(position);
        list.remove(triple);

 */
        for (int j = 0; j < list.size(); j++) {
            Triple oldTriple = (Triple) list.get(j);
            if(oldTriple.getColume()==triple.getColume()){
                list.remove(j);
            }
        }
    }

    public void remove_Vertex(T vertex){
        int position = 0;
        for (int i = 0; i < this.vertexNodeList.size(); i++) {
            if(this.vertexNodeList.get(i).date.equals(vertex)){
                position = i;
                break;
            }

        }
        //System.out.println(position)
        MySingleLinked_SortedList<Triple> list = this.vertexNodeList.get(position).rowlist;
        MyList needRemove = new MyList();
        for(Node<Triple> p = list.head.next; p!=null; p=p.next) {     //从要删除的那个顶点对应的单链表开始，
            needRemove.add(p.date.getColume());
        }
        /*
        for (int i = 0; i < needRemove.size(); i++) {
            System.out.println(needRemove.get(i));

            for (int j = 0; j < this.vertexNodeList.size(); j++) {
                if(j!=position){
                    MySingleLinked_SortedList<Triple> list1 = this.vertexNodeList.get(j).rowlist;

                    int key=0;
                    for(Node<Triple> p = list1.head.next; p!=null; p=p.next) {
                        if(p.date.getRow()==i){
                            list1.remove(key);
                        }
                        key++;

                    }
                }

            }
        }

         */
        for (int j = 0; j < this.vertexNodeList.size(); j++) {
            if(j!=position){
                MySingleLinked_SortedList<Triple> list1 = this.vertexNodeList.get(j).rowlist;

                int key=0;
                for(Node<Triple> p = list1.head.next; p!=null; p=p.next) {
                    if(p.date.getColume()==position){
                        list1.remove(key);
                    }
                    key++;

                }
            }

        }

        this.vertexNodeList.remove(position);

        for (int i = 0; i < this.vertexNodeList.size(); i++) {

            MySingleLinked_SortedList<Triple> list1 = this.vertexNodeList.get(i).rowlist;
            int size = list1.size();
            for(Node<Triple> p = list1.head.next; p!=null; p=p.next){
                if(p.date.getRow()>=position){
                    p.date.setRow(p.date.getRow()-1);
                }
                if(p.date.getColume()>=position){
                    p.date.setColume(p.date.getColume()-1);
                }

            }

        }

/*
        for (int i = position; i < this.vertexNodeList.size(); i++) {
            for (int j = 0; j < vertexNodeList.get(i).rowlist.size(); j++) {
                Triple triple = (Triple) vertexNodeList.get(i).rowlist.get(j);
                triple.setRow(triple.getRow()-1);
                //triple.setColume(triple.getColume()-1);

            }

        }
*/
        /*
        for (int i = 0; i < list.size(); i++) {
            needRemove.add((Triple) list.get(i));
            //needRemove.set(i,needRemove.get(i).toSymmetry());
        }

        for (int i = 0; i < this.vertexNodeList.size(); i++) {
            MySingleLinked_SortedList<Triple> list1 = this.vertexNodeList.get(i).rowlist;
            int size = list1.size();
            for(Node<Triple> p = list1.head.next; p!=null; p=p.next){     //从要删除的那个顶点对应的单链表开始，

            }

        }

         */

    }


    public int NextNeighbor(int i,int j){
        if(i>=0 && i<this.vertexNodeList.size() && j>=-1 && j<this.vertexNodeList.size() && i!=j){
            MySingleLinked_SortedList<Triple> list2 = this.vertexNodeList.get(i).rowlist;
            for(Node<Triple> p = list2.head.next; p!=null; p=p.next){
                if(p.date.getColume()>j){
                    return p.date.getColume();
                }
            }

        }
        return -1;

    }

    public int FirstNeighbor(int i){
        return this.NextNeighbor(i,-1);
    }

    public void DFS_Recursion(int i, boolean[] visited){
        System.out.print(this.vertexNodeList.get(i).date+" ");
        visited[i]=true;
        for(int j = FirstNeighbor(i); j!=-1; j = NextNeighbor(i,j)){
            if(!visited[j]){
                DFS_Recursion(j,visited);
                //System.out.print(this.vertexNodeList.get(i).date+"***");
            }
        }

    }

    public void DFS_NonRecursive(int i,boolean[] visited){
        MyStack<Integer> stack = new LinkedStack<>();
        int j;
        stack.push(i);
        visited[i]=true;
        while(!stack.isEmpty()){
            j=stack.pop();
            System.out.print(this.vertexNodeList.get(j).date+" ");
            for(int v = FirstNeighbor(j); v!=-1; v = NextNeighbor(j,v)){
                if(!visited[v]){
                    stack.push(v);
                    visited[v]=true;
                    //System.out.print(this.vertexNodeList.get(i).date+"***");
                }
            }
        }
        System.out.println();
    }

    public void BFS_Queue(int i,boolean[] visited){
        LinkedQueue<Integer> queue = new LinkedQueue<>();
        System.out.print(this.vertexNodeList.get(i).date+" ");

        visited[i] = true;
        queue.add(i);
        while (!queue.isEmpty()){
            i=queue.poll();
            for(int j=FirstNeighbor(i);j!=-1;j=NextNeighbor(i,j)){
                if(!visited[j]){
                    System.out.print(this.vertexNodeList.get(j).date+" ");
                    visited[j] =true;
                    queue.add(j);
                }
            }

        }


    }
    
    
    public int weight(int i , int j){
        if(i==j){
            return 0; 
        }
        int w = 0;
        MySingleLinked_SortedList list = this.vertexNodeList.get(i).rowlist;
        for (int k = 0; k < list.size(); k++) {
            Triple triple = (Triple) list.get(k);
            if(triple.getColume()==j){
                w = triple.getValue();
                break;
            }
        }
        return w!=0? w:MAX_WEIGHT;
    }


    public void minSpanTree()   //prim
    {
        Triple[] mst = new Triple[this.vertexNodeList.size()-1];         //边数为顶点数n-1
        for(int i=0;  i<mst.length;  i++){
            mst[i]=new Triple(0, i+1, this.weight(0,i+1));     //保存从一个顶点到其他各顶点的边
        }

        for(int i=0;  i<mst.length;  i++)
        {
            int min=i;           //最小权值边的下标
            for(int j=i+1;  j<mst.length;  j++){
                if(mst[j].getValue() < mst[min].getValue()){
                    min = j;              //保存当前权值最小边的序号
                }
            }


            //将权值最小的边（由min记得）交换到第i个元素
            Triple edge = mst[min];
            if(min!=i)
            {
                mst[min] = mst[i];
                mst[i] = edge;
            }

            //将i+1～n-1的其他边用权值更小的边替换
            int tv = edge.getColume();
            for(int j=i+1;  j<mst.length;  j++)
            {
                int v = mst[j].getColume(), w;
                if((w=weight(tv,v)) < mst[j].getValue())//若(tv,v)边的权值w更小，则替换
                    mst[j] = new Triple(tv,v,w);
            }
        }

        System.out.print("\n最小生成树的边集合：");
        int mincost=0;
        for(int i=0;  i<mst.length;  i++)        //输出最小生成树的边集合和代价
        {
            System.out.print(mst[i]+" ");
            mincost += mst[i].getValue();
        }
        System.out.println("，最小代价为"+mincost);
    }



}
