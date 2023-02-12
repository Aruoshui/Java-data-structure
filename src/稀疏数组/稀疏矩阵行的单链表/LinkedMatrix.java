package 稀疏数组.稀疏矩阵行的单链表;


import 稀疏数组.三元组.Triple;
import 链表.单链表.MySingleLinkedList;
import 链表.单链表.MySingleLinked_SortedList;
import 链表.单链表.Node;
import 顺序表.MyList;
import javax.xml.stream.events.NotationDeclaration;

public class LinkedMatrix {
    int rows , columns;
    public MyList<MySingleLinked_SortedList<Triple>> rowlist;    // 行指针顺序表，元素是排序单链表

    public LinkedMatrix(int rows, int columns) {
        if(rows>=0 && columns>=0){
            this.rows = rows;
            this.columns = columns;
            this.rowlist = new MyList<MySingleLinked_SortedList<Triple>>(rows);  //构造一个有rows行的行顺序表

            for(int i = 0; i<rows ;i++){
                this.rowlist.add(new MySingleLinked_SortedList<Triple>(null));
            }

        }
    }

    public LinkedMatrix(int rows , int columns , Triple[] triples){
        this(rows,columns);
        for(int i = 0;i<triples.length;i++){
            this.set(triples[i]);
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }


    public int get(int i,int j){
        if(i>=0 && i<this.rows && j>=0 && j<this.columns){
            int positon = this.rowlist.get(i).indexof(new Triple(i,j,0));
            return (this.rowlist.get(i).get(positon)!=null)? (int) this.rowlist.get(i).get(positon) :-1;
        }
        return 0;
    }

    public void set(int i,int j, int x){
        if(i>=0 && i<this.rows && j>=0 && j<this.columns){
            MySingleLinked_SortedList<Triple> link = this.rowlist.get(i);
            if(x==0){
                link.remove(new Triple(i,j,x));   //如果权值为0，则移除
            }else {
                Triple tirple = new Triple(i,j,x);
                if(link.indexof(tirple)!=-1){
                    link.set(link.indexof(tirple),tirple);
                }else{
                    link.add(tirple);
                }


            }
        }
    }

    public void set(Triple triple) {
        this.set(triple.getRow(),triple.getColume(),triple.getValue());
    }




    public String toString() {
        String str = "";
        for (int i = 0; i < this.rowlist.size(); i++) {

            str += i + " -> " + this.rowlist.get(i) + "\n";

        }
        return str;

    }


    /*


    public void printMatrix(){
        System.out.println("矩阵"+this.getClass().getName()+"("+rows+"x"+columns+"):");
        for(int i=0;i<this.rows;i++){
            Node<Triple> p = this.rowlist.get(i).head.next;
            for(int j=0;j<this.columns;j++){
                if(p!=null && j==p.date.getColume()){
                    System.out.println(String.format("%4d",p.date.getValue()));
                    p=p.next;
                }else{
                    System.out.println(String.format("%4d",0));
                }

            }

        }
    }
    */

}
