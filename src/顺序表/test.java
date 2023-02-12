package 顺序表;

public class test {
    public static void main(String[] args) {
        MyList myList = new MyList(10);
        myList.add(0,"我的名字是");
//        System.out.println(myList.get(0));
        myList.add('q');
//        System.out.println(myList.get(1));
        myList.add(1);
        for (int i=0;i<myList.size();i++){
            System.out.print(myList.get(i)+"\t");
        }
        System.out.println("\n---------------------------");

        myList.clear();
        System.out.println(myList.length);
        System.out.println(myList);                           //数组空间未删除
        System.out.println("---------------------------");

        myList.add(0);
        myList.add(1);
        myList.add(2);

        myList.set(0,10000);
        System.out.println("修改前");
        for (int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }

        myList.remove(0);
        System.out.println("删除0号后");
        for (int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }

        System.out.println("---------------------------");

        myList.clear();
        myList.add(0);
        myList.add(2);
        myList.add(3);
        myList.add(1);
        myList.add(1);

        System.out.println("输出对应的索引值");
        System.out.println("1的索引值为"+myList.indexof(1));

        System.out.println("---------------------------");
        System.out.println("排序后");
        myList.sort();
        for (int i=0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }

    }
}
