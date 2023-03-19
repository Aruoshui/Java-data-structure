package 高级Java程序开发.第二次作业.序列化学生列表;

import java.io.*;
import java.util.Scanner;
import javax.swing.*;

public class Student implements Serializable { // Student 类实现 Serializable 接口
    private String id;
    private String name;
    private String birthplace;

    public Student(String id, String name, String birthplace) {
        this.id = id;
        this.name = name;
        this.birthplace = birthplace;
    }

    public String getId() { // 获取 id
        return id;
    }

    public String getName() { // 获取 name
        return name;
    }

    public String getBirthplace() { // 获取 birthplace
        return birthplace;
    }

}
