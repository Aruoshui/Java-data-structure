package 链表.单链表;

public class test {
    public static void main(String[] args) {

        MySingleLinkedList List = new MySingleLinkedList(new Node());
        System.out.println(List.size());

        System.out.println("*****************************");

        List.add('x');
        System.out.println(List.size());

        System.out.println("*****************************");
        List.add(1,'q');
        for(int i=0;i<List.size();i++){
            System.out.println(List.get(i));
        }

        System.out.println("*****************************");
        List.clear();
        System.out.println(List.size());


        System.out.println("*****************************");
        List.add(1);
        List.set(0,1000);
        System.out.println(List.get(0));

        System.out.println("*****************************");
        List.clear();
        List.add(0,1);
        List.add(1,2);
        List.add(2,3);

        System.out.println(List.indexof(2));
        System.out.println(List.indexof(3));


        System.out.println("*****************************");
        List.remove(0);
        System.out.println(List.get(0));

        //List.remove(2);


        System.out.println("*****************************");
        List.clear();
        List.add(0,1);
        List.add(1,2);
        List.add(2,3);

        List.reverse();


        for(int i=0;i<List.size();i++){
            System.out.println(List.get(i));
        }




/*
        MySingleLinked_SortedList List = new MySingleLinked_SortedList(new Node());
        //List.order = true;
        List.add(10);
        List.add(1);
        List.add(20);


        for (int i = 0; i < List.size(); i++) {
            System.out.println(List.get(i));
        }

*/
    }
}
