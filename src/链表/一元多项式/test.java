package 链表.一元多项式;

public class test {
    public static void main(String[] args) {
        //多项式p1
        PolyList p1=new PolyList();
        p1.insert(new PolyNode(2,1));
        p1.insert(new PolyNode(1,3));
        p1.insert(new PolyNode(1,5));
        p1.insert(new PolyNode(3,7));
        System.out.println("p1="+p1.printS());
        //多项式p2
        PolyList p2=new PolyList();
        p2.insert(new PolyNode(2,1));
        p2.insert(new PolyNode(1,2));
        p2.insert(new PolyNode(2,3));
        p2.insert(new PolyNode(-1,5));
        System.out.println("p2="+p2.printS());
        //相加
        PolyList resultList1= PolyList.add(p1, p2);
        System.out.println("p1+p2="+resultList1.printS());

    }
}
