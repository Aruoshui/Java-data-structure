package 图2.邻接表;

import 稀疏数组.三元组.Triple;
import 链表.单链表.MySingleLinked_SortedList;

public class VertexNode<T> {
    public T date;                                        //顶点的数据
    public MySingleLinked_SortedList<Triple>   rowlist;   //该顶点的边单链表，用三元组存储边和权

    public VertexNode(T date, MySingleLinked_SortedList<Triple> rowlist) {
        this.date = date;
        this.rowlist = rowlist;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public MySingleLinked_SortedList<Triple> getRowlist() {
        return rowlist;
    }

    public void setRowlist(MySingleLinked_SortedList<Triple> rowlist) {
        this.rowlist = rowlist;
    }


}

