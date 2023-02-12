package 类与对象.方法的调用;

public class 对象的克隆 {
    public static void main(String[] args) {
        Person p=new Person();
        p.name="fds";
        p.age=12;

        MyTools tools = new MyTools();

        Person p2 = tools.copyPerson(p);

        //p，p2都是Person的对象，但是是两个独立的对象，属性相同

    }
}
class Person{
    String name;
    int age;

}
class MyTools{
    public Person copyPerson(Person p){
        Person p2 = new Person();

        p2.name=p.name;
        p2.age=p.age;

        return p2;
    }
}
