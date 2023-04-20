package 测试;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HobbySelector extends JFrame implements ActionListener {
    private JTextField nameField;
    private JCheckBox musicCheckBox;
    private JCheckBox sportsCheckBox;
    private JCheckBox internetCheckBox;
    private JRadioButton managerRadioButton;
    private JRadioButton engineerRadioButton;
    private JRadioButton teacherRadioButton;
    private JButton okButton;
    private JButton exitButton;

    public HobbySelector() {

        super("Hobby Selector");
        setLayout(new FlowLayout());


        nameField = new JTextField(10);
        musicCheckBox = new JCheckBox("音乐");
        sportsCheckBox = new JCheckBox("运动");
        internetCheckBox = new JCheckBox("上网");
        managerRadioButton = new JRadioButton("经理");
        engineerRadioButton = new JRadioButton("工程师");
        teacherRadioButton = new JRadioButton("教师");
        okButton = new JButton("OK");
        exitButton = new JButton("Exit");


        ButtonGroup group = new ButtonGroup();
        group.add(managerRadioButton);
        group.add(engineerRadioButton);
        group.add(teacherRadioButton);


        add(new JLabel("名字："));
        add(nameField);
        add(musicCheckBox);
        add(sportsCheckBox);
        add(internetCheckBox);
        add(managerRadioButton);
        add(engineerRadioButton);
        add(teacherRadioButton);
        add(okButton);
        add(exitButton);


        okButton.addActionListener(this);
        exitButton.addActionListener(this);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250, 200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == okButton) {
            String name = nameField.getText();
            String hobbies = "";
            if (musicCheckBox.isSelected()) {
                hobbies += "音乐 ";
            }
            if (sportsCheckBox.isSelected()) {
                hobbies += "运动 ";
            }
            if (internetCheckBox.isSelected()) {
                hobbies += "上网 ";
            }
            String aspiration = "";
            if (managerRadioButton.isSelected()) {
                aspiration = "经理";
            } else if (engineerRadioButton.isSelected()) {
                aspiration = "工程师";
            } else if (teacherRadioButton.isSelected()) {
                aspiration = "教师";
            }
            JOptionPane.showMessageDialog(this, "名字: " + name + "\n爱好: " + hobbies + "\n职业: " + aspiration);
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        HobbySelector frame = new HobbySelector();
        frame.setVisible(true);
    }
}
