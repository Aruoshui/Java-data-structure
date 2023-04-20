package 高级Java程序开发.第五次作业;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UserRegistrationLoginApp extends JFrame implements ActionListener {
    private JTextField txtUsername, txtPassword, txtBirthdate, txtAge, txtEmail, txtHobbies;
    private JButton btnRegister, btnLogin;
    private Connection connection;

    public UserRegistrationLoginApp() {

        setTitle("用户注册与登录");

        setSize(400, 400);

        // 网格布局
        setLayout(new GridLayout(8,1));

        JLabel lblUsername = new JLabel("用户名:");
        txtUsername = new JTextField();
        add(lblUsername);
        add(txtUsername);

        JLabel lblPassword = new JLabel("密码:");
        txtPassword = new JTextField();
        add(lblPassword);
        add(txtPassword);

        JLabel lblBirthdate = new JLabel("出生日期:");
        txtBirthdate = new JTextField();
        add(lblBirthdate);
        add(txtBirthdate);

        JLabel lblAge = new JLabel("年龄:");
        txtAge = new JTextField();
        add(lblAge);
        add(txtAge);

        JLabel lblEmail = new JLabel("邮箱:");
        txtEmail = new JTextField();
        add(lblEmail);
        add(txtEmail);

        JLabel lblHobbies = new JLabel("爱好:");
        txtHobbies = new JTextField();
        add(lblHobbies);
        add(txtHobbies);


        btnRegister = new JButton("注册");
        btnRegister.addActionListener(this);
        add(btnRegister);


        btnLogin = new JButton("登录");
        btnLogin.addActionListener(this);
        add(btnLogin);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegister) {

            String username = txtUsername.getText().trim();
            String password = txtPassword.getText().trim();
            String birthdate = txtBirthdate.getText().trim();
            int age = Integer.parseInt(txtAge.getText().trim());
            String email = txtEmail.getText().trim();
            String hobbies = txtHobbies.getText().trim();


            if (checkUsernameExist(username)) {
                JOptionPane.showMessageDialog(this, "用户名已存在，请重新输入", "注册失败", JOptionPane.ERROR_MESSAGE);
                return;
            }


            if (insertUser(username, password, birthdate, age, email, hobbies)) {
                JOptionPane.showMessageDialog(this, "注册成功", "注册结果", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "注册失败，请稍后再试", "注册结果", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnLogin) {    //登录
            // 获取用户输入的用户名和密码
            String username = txtUsername.getText().trim();
            String password = txtPassword.getText().trim();


            if (checkUser(username, password)) {
                JOptionPane.showMessageDialog(this, "登录成功", "登录结果", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "登录失败，请检查用户名和密码", "登录结果", JOptionPane.ERROR_MESSAGE);
            }
        }
    }


    private boolean checkUsernameExist(String username) {
        boolean exist = false;
        try {

            connectDB();


            String query = "SELECT * FROM MyUser WHERE username=?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            // 如果查询结果不为空，则表示用户名已存在
            if (rs.next()) {
                exist = true;
            }


            closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }


    private void connectDB() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=JDBCTest"; // 数据库连接URL
        String user = "zh"; // 数据库用户名
        String password = "1234567890"; // 数据库密码


        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        connection = DriverManager.getConnection(url, user, password);
    }


    private void closeDB() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }


    private boolean insertUser(String username, String password, String birthdate, int age, String email,
                               String hobbies) {
        boolean success = false;
        try {

            connectDB();

            // 插入用户信息
            String query = "INSERT INTO MyUser (username, password, birthdate, age, email, hobbies) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, birthdate);
            stmt.setInt(4, age);
            stmt.setString(5, email);
            stmt.setString(6, hobbies);


            int rowsAffected = stmt.executeUpdate();

            // 插入成功，返回true
            if (rowsAffected > 0) {
                success = true;
            }


            closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }


    private boolean checkUser(String username, String password) {
        boolean valid = false;
        try {

            connectDB();
            
            String query = "SELECT * FROM MyUser WHERE username=? AND password=?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            // 如果查询结果不为空，则表示登录信息有效
            if (rs.next()) {
                valid = true;
            }


            closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valid;
    }

    public static void main(String[] args) {
        UserRegistrationLoginApp app = new UserRegistrationLoginApp();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}


