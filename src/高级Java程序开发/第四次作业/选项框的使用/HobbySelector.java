package 高级Java程序开发.第四次作业.选项框的使用;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HobbySelector extends JFrame implements ActionListener {
    private JLabel nameLabel, hobbyLabel, jobLabel, goalLabel;
    private JTextField nameField;
    private JCheckBox musicCheckBox, sportCheckBox, internetCheckBox;
    private ButtonGroup jobGroup;
    private JRadioButton managerRadioButton, engineerRadioButton, teacherRadioButton;
    private JComboBox<String> goalComboBox;
    private JButton okButton, exitButton;

    public HobbySelector() {
        setTitle("兴趣爱好选择程序");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 10, 10));

        nameLabel = new JLabel("姓名：");
        add(nameLabel);
        nameField = new JTextField();
        add(nameField);

        hobbyLabel = new JLabel("爱好：");
        add(hobbyLabel);
        musicCheckBox = new JCheckBox("音乐");
        add(musicCheckBox);
        sportCheckBox = new JCheckBox("运动");
        add(sportCheckBox);
        internetCheckBox = new JCheckBox("上网");
        add(internetCheckBox);

        jobLabel = new JLabel("职业：");
        add(jobLabel);
        jobGroup = new ButtonGroup();
        managerRadioButton = new JRadioButton("经理");
        jobGroup.add(managerRadioButton);
        add(managerRadioButton);
        engineerRadioButton = new JRadioButton("工程师");
        jobGroup.add(engineerRadioButton);
        add(engineerRadioButton);
        teacherRadioButton = new JRadioButton("教师");
        jobGroup.add(teacherRadioButton);
        add(teacherRadioButton);

        goalLabel = new JLabel("志向：");
        add(goalLabel);
        String[] goals = {"学习", "娱乐", "两者兼顾"};
        goalComboBox = new JComboBox<>(goals);
        add(goalComboBox);

        okButton = new JButton("确定");
        add(okButton);
        okButton.addActionListener(this);
        exitButton = new JButton("退出");
        add(exitButton);
        exitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            String name = nameField.getText();
            String hobby = "";
            if (musicCheckBox.isSelected()) {
                hobby += "音乐 ";
            }
            if (sportCheckBox.isSelected()) {
                hobby += "运动 ";
            }
            if (internetCheckBox.isSelected()) {
                hobby += "上网";
            }
            String job = "";
            if (managerRadioButton.isSelected()) {
                job = "经理";
            }
            if (engineerRadioButton.isSelected()) {
                job = "工程师";
            }
            if (teacherRadioButton.isSelected()) {
                job = "教师";
            }
            String goal = (String) goalComboBox.getSelectedItem();
            String message = "姓名：" + name + "\n爱好：" + hobby + "\n职业：" + job + "\n志向：" + goal;
            JOptionPane.showMessageDialog(this, message);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        HobbySelector hs = new HobbySelector();
        hs.setVisible(true);
    }
}
