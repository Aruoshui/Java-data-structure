package 图;

import 顺序表.MyList;

import static java.lang.Float.POSITIVE_INFINITY;

public class Graph<T> {

    public static final int MAX_WEIGHT = (int) POSITIVE_INFINITY;  //表示无穷大权值

    public MyList<T> GraphVertexList;

    public Graph(){                 //
        this.GraphVertexList = new MyList<>();
    }

    public Graph(T[] vertexes) {
        this.GraphVertexList = new MyList<T>();
        for (int i = 0; i < vertexes.length; i++) {
            GraphVertexList.add(i,vertexes[i]);
        }

    }

    public int VertexCount(){
        return this.GraphVertexList.size();
    }

    public String toString_Vertex(){
        String str="";
        for (int i = 0; i < GraphVertexList.size(); i++) {
            str+=GraphVertexList.get(i);
        }

        return str;

    }

}

