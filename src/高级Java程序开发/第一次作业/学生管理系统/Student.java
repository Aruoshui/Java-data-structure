package 高级Java程序开发.第一次作业.学生管理系统;

public class Student {
    private String id;       //学生ID
    private String name;     //学生姓名
    private String gender;   //学生的性别
    private String hometown; //学生的籍贯

    public Student(String id, String name, String gender, String hometown) {    //Student对象的构造方法，要求包含学生的学号，姓名，性别，籍贯
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.hometown = hometown;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    @Override
    public String toString() {
        return "学号：" + id + "，姓名：" + name + "，性别：" + gender + "，籍贯：" + hometown;
    }



}
