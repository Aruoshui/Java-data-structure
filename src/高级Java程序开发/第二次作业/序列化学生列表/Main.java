package 高级Java程序开发.第二次作业.序列化学生列表;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) { // 主函数

        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入学生数量：");
        int count = scanner.nextInt();
        Student[] students = new Student[count];
        String filePath = null; // 保存文件路径

        // 使用文件对话框选择保存文件路径
        JFileChooser fileChooser = new JFileChooser(); // 创建文件选择器
        int result = fileChooser.showSaveDialog(null); // 显示文件保存对话框，并记录用户的操作结果
        if (result == JFileChooser.APPROVE_OPTION) { // 如果用户选择“保存”
            File selectedFile = fileChooser.getSelectedFile(); // 获取用户选择的文件
            filePath = selectedFile.getAbsolutePath();
        }

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath)); // 创建 ObjectOutputStream 对象，并打开文件流
            for (int i = 0; i < students.length; i++) {
                String id = JOptionPane.showInputDialog("请输入学号：");
                String name = JOptionPane.showInputDialog("请输入姓名：");
                String birthplace = JOptionPane.showInputDialog("请输入出生地：");
                students[i] = new Student(id, name, birthplace);
                oos.writeObject(students[i]); // 序列化 Student 对象，并写入文件
            }
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath)); // 创建 ObjectInputStream 对象，并打开文件流
            for (int i = 0; i < students.length; i++) {
                Student s = (Student) ois.readObject(); // 反序列化 Student 对象
                System.out.println("学号：" + s.getId());
                System.out.println("姓名：" + s.getName());
                System.out.println("出生地：" + s.getBirthplace());
                System.out.println("---------------");
            }
            ois.close();
        } catch (IOException | ClassNotFoundException e) { // 处理 IO 异常和类未找到异常
            e.printStackTrace();
        }
    }
}
