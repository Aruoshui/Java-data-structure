package 高级Java程序开发.测试专用;

import java.io.*;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Student implements Serializable {


    private String studentID; // 学号
    private String name; // 姓名
    private String birthplace; // 出生地


    public Student(String studentID, String name, String birthplace) {
        this.studentID = studentID;
        this.name = name;
        this.birthplace = birthplace;
    }


    public String getStudentID() {
        return studentID;
    }

    public String getName() {
        return name;
    }

    public String getBirthplace() {
        return birthplace;
    }

    // 主函数
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        String fileName = null;

        // 创建文件选择对话框并等待用户选择保存位置
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            fileName = file.getAbsolutePath();
        }

        // 将学生信息写入文件
        try {
            // 创建 ObjectOutputStream 对象来序列化对象到文件
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(fileName));

            // 提示用户输入学生数量
            System.out.print("请输入学生数量：");
            int count = scanner.nextInt();
            scanner.nextLine();


            for (int i = 0; i < count; i++) {
                System.out.print("请输入第" + (i + 1) + "个学生的学号：");
                String studentID = scanner.nextLine();
                System.out.print("请输入第" + (i + 1) + "个学生的姓名：");
                String name = scanner.nextLine();
                System.out.print("请输入第" + (i + 1) + "个学生的出生地：");
                String birthplace = scanner.nextLine();

                // 创建学生对象并序列化到文件
                Student student = new Student(studentID, name, birthplace);
                output.writeObject(student);
            }


            output.close();


            System.out.println("学生信息已保存到文件 " + fileName);

            // 从文件中读取学生信息并显示
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(fileName));
            System.out.println("从文件中读取学生信息：");

            try {
                while (true) {
                    // 读取学生对象并显示学生信息
                    Student student = (Student) input.readObject();
                    System.out.println("学号：" + student.getStudentID() +
                            "，姓名：" + student.getName() +
                            "，出生地：" + student.getBirthplace());
                }
            } catch (EOFException ex) {
                // 到达文件末尾，停止读取
            }

            // 关闭输入流
            input.close();
        } catch (IOException ex) {

            System.out.println("保存或读取文件出错：" + ex);
        } catch (ClassNotFoundException ex) {

        }
    }
}