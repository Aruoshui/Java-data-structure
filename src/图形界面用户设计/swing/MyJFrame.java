package 图形界面用户设计.swing;

import netscape.security.UserTarget;

import javax.swing.*;
import java.awt.*;


public class MyJFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("我的第一个GUI程序");
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(new Button("ok"));
        frame.getContentPane().add(new Button("cancel"));
        frame.setSize(200,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
