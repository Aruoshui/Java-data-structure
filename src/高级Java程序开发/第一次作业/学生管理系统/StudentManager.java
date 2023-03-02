package 高级Java程序开发.第一次作业.学生管理系统;


//1.选择一种list接口的实现类，实现学生管理系统对学生的增删改查，查找时按照学号进行查询(每个学生的信息包括学号、姓名、性别、籍贯等) ;

import java.util.ArrayList;    //调用ArrayLis接口实现
import java.util.Scanner;

public class StudentManager {
    ArrayList<Student> students = new ArrayList<Student>();  //创建学生列表，存储学生对象
    Scanner scanner = new Scanner(System.in);  //输入

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        manager.start();
    }

    public void start() {
        while (true) {
            System.out.println("\n学生管理系统");
            System.out.println("1. 添加学生");
            System.out.println("2. 删除学生");
            System.out.println("3. 修改学生信息");
            System.out.println("4. 查找学生");
            System.out.println("5. 显示所有学生");
            System.out.println("0. 退出");
            System.out.print("请选择操作：");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    findStudent();
                    break;
                case 5:
                    showAllStudents();
                    break;
                case 0:
                    System.out.println("谢谢使用！");
                    System.exit(0);
                default:
                    System.out.println("输入有误，请重新选择。");
            }
        }
    }

    private void addStudent() {
        System.out.println("添加学生");
        System.out.print("请输入学号：");
        String id = scanner.next();
        System.out.print("请输入姓名：");
        String name = scanner.next();
        System.out.print("请输入性别：");
        String gender = scanner.next();
        System.out.print("请输入籍贯：");
        String hometown = scanner.next();
        Student student = new Student(id, name, gender, hometown);
        students.add(student);
        System.out.println("添加成功！");
    }

    private void deleteStudent() {
        System.out.println("删除学生");
        System.out.print("请输入要删除的学生的学号：");
        String id = scanner.next();
        int index = findStudentIndex(id);
        if (index == -1) {
            System.out.println("未找到该学生！");
        } else {
            students.remove(index);
            System.out.println("删除成功！");
        }
    }

    private void updateStudent() {
        System.out.println("修改学生信息");
        System.out.print("请输入要修改的学生的学号：");
        String id = scanner.next();
        int index = findStudentIndex(id);
        if (index == -1) {
            System.out.println("未找到该学生！");
        } else {
            Student student = students.get(index);
            System.out.print("请输入新的姓名（留空表示不修改）：");
            String name = scanner.next();
            if (!name.equals("")) {
                student.setName(name);
            }
            System.out.print("请输入新的性别（留空表示不修改）：");
            String gender = scanner.next();
            if (!gender.equals("")) {
                student.setGender(gender);
            }
            System.out.print("请输入新的籍贯（留空表示不修改）：");
            String hometown = scanner.next();
            if (!hometown.equals("")) {
                student.setHometown(hometown);
            }
            System.out.println("修改成功！");
        }
    }

    private void findStudent() {
        System.out.println("查找学生");
        System.out.print("请输入要查找的学生的学号：");
        String id = scanner.next();
        int index = findStudentIndex(id);
        if (index == -1) {
            System.out.println("未找到该学生！");
        } else {
            Student student = students.get(index);
            System.out.println("找到了该学生：");
            System.out.println(student);
        }
    }

    private void showAllStudents() {
        System.out.println("所有学生：");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private int findStudentIndex(String id) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
