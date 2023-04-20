package 高级Java程序开发.第六次作业.MVC设计;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class View_UserRegistrationLoginView extends JFrame implements ActionListener {
    private JTextField txtUsername, txtPassword, txtBirthdate, txtAge, txtEmail, txtHobbies;
    private JButton btnRegister, btnLogin;
    private Connection connection;

    public View_UserRegistrationLoginView() {

        setTitle("用户注册与登录");

        setSize(400, 400);

        // 边界布局
        setLayout(new BorderLayout());

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        int verticalGap = 2; // 设置垂直间隔

        JLabel lblUsername = new JLabel("用户名:");
        txtUsername = new JTextField();
        panelCenter.add(lblUsername);
        panelCenter.add(Box.createVerticalStrut(verticalGap));
        panelCenter.add(txtUsername);

        JLabel lblPassword = new JLabel("密码:");
        txtPassword = new JTextField();
        panelCenter.add(lblPassword);
        panelCenter.add(Box.createVerticalStrut(verticalGap));
        panelCenter.add(txtPassword);

        JLabel lblBirthdate = new JLabel("出生日期:");
        txtBirthdate = new JTextField();
        panelCenter.add(lblBirthdate);
        panelCenter.add(Box.createVerticalStrut(verticalGap));
        panelCenter.add(txtBirthdate);

        JLabel lblAge = new JLabel("年龄:");
        txtAge = new JTextField();
        panelCenter.add(lblAge);
        panelCenter.add(Box.createVerticalStrut(verticalGap));
        panelCenter.add(txtAge);

        JLabel lblEmail = new JLabel("邮箱:");
        txtEmail = new JTextField();
        panelCenter.add(lblEmail);
        panelCenter.add(Box.createVerticalStrut(verticalGap));
        panelCenter.add(txtEmail);

        JLabel lblHobbies = new JLabel("爱好:");
        txtHobbies = new JTextField();
        panelCenter.add(lblHobbies);
        panelCenter.add(Box.createVerticalStrut(verticalGap));
        panelCenter.add(txtHobbies);

        add(panelCenter, BorderLayout.CENTER);

        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.Y_AXIS));

        btnRegister = new JButton("注册");
        btnRegister.addActionListener(this);
        panelSouth.add(btnRegister);

        panelSouth.add(Box.createVerticalStrut(verticalGap)); // 添加垂直间隔

        btnLogin = new JButton("登录");
        btnLogin.addActionListener(this);
        panelSouth.add(btnLogin);

        add(panelSouth, BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {
        DataControl us = new DataControl();
        if (e.getSource() == btnRegister) {

            String username = txtUsername.getText().trim();
            String password = txtPassword.getText().trim();
            String birthdate = txtBirthdate.getText().trim();
            int age = Integer.parseInt(txtAge.getText().trim());
            String email = txtEmail.getText().trim();
            String hobbies = txtHobbies.getText().trim();

            if (us.checkUsernameExist(username)) {
                JOptionPane.showMessageDialog(this, "用户名已存在，请重新输入", "注册失败", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (us.insertUser(username, password, birthdate, age, email, hobbies)) {
                JOptionPane.showMessageDialog(this, "注册成功", "注册结果", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "注册失败", "注册结果", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnLogin) {
            String username = txtUsername.getText().trim();
            String password = txtPassword.getText().trim();
            if (us.checkUser(username, password)) {
                JOptionPane.showMessageDialog(this, "登录成功", "登录结果", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "登录失败，请检查用户名和密码", "登录结果", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}



