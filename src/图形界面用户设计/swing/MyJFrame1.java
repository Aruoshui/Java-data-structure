package 图形界面用户设计.swing;

import javax.swing.*;
import java.awt.*;

public class MyJFrame1 extends JFrame {
    public MyJFrame1 (String title){
        super(title);
        Container cp = this.getContentPane();
        cp.setLayout(new FlowLayout(FlowLayout.LEFT,10,30));
        cp.add(new Button("按钮1"));
        cp.add(new Button("按钮2"));
        cp.add(new Button("按钮3"));
        cp.add(new Button("按钮4"));

    }

    public static void main(String[] args) {
        MyJFrame1 frame1 = new MyJFrame1("TestFlowLayout");
        frame1.setSize(300,200);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
    }
}
