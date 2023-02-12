package 链表.一元多项式;

public class PolyList {
    PolyNode head;      //头结点
    PolyNode current;

    public PolyList() {
        head = new PolyNode();
        current = head;
        head.next = null;
    }

    //是否为空
    public boolean isEmpty() {
        return head.next == null;
    }

    //只考虑按顺序插⼊元素
    public void insert(PolyNode node) {
        current.next = node;
        current = node;
    }

    //打印多项式
    public String printS() {
        StringBuilder s = new StringBuilder();
        StringBuilder a = new StringBuilder();
        StringBuilder i = new StringBuilder();
        StringBuilder operator = new StringBuilder();
        current = head.next;
        while (current != null){
            a.delete(0, a.length());
            i.delete(0, i.length());
            operator.delete(0, operator.length());
            if (current.getA() == 1)    //系数为一则空
                a.append("");
            else
                a.append(String.valueOf(current.getA()));
            if (current.getI() == 1) {  //次幂为一则空
                i.append("");
                operator.append(a.toString()).append("x").append(i.toString());
            } else {
                i.append(String.valueOf(current.getI()));
                operator.append(a.toString()).append("x^").append(i.toString());
            }
            if (current == head.next)
                s.append(operator.toString());
            else
                s.append("+").append(operator.toString());
            current = current.next;
        }
        return s.toString();
    }

    public static PolyList add(PolyList p1, PolyList p2) {
        PolyList result = new PolyList();
        //分别指向p1 p2的第⼀个元素
        p1.current = p1.head.next;
        p2.current = p2.head.next;

        //运算
        while (p1.current != null && p2.current != null) {
            if (p1.current.getI() == p2.current.getI()) {
                if(p1.current.getA()+p2.current.getA()==0){
                    p1.current = p1.current.next;
                    p2.current = p2.current.next;
                }else{
                    result.insert(new PolyNode(p1.current.getA() + p2.current.getA(), p1.current.getI()));
                    p1.current = p1.current.next;
                    p2.current = p2.current.next;
                }

            } else if (p1.current.getI() < p2.current.getI()) {
                result.insert(p1.current);
                p1.current = p1.current.next;
            } else {
                result.insert(p2.current);
                p2.current = p2.current.next;
            }
        }

        //将剩余没有相加操作的输出
        while (p1.current != null) {
            result.insert(p1.current);
            p1.current = p1.current.next;
        }
        while (p2.current != null) {
            result.insert(p2.current);
            p2.current = p2.current.next;
        }


        return result;
    }
}