package 测试.界面;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BaseConnection extends JFrame implements ActionListener {
    private JTextField txtuname, txtupassword, txtubirthdate, txtuage, txtuemail, txtuhobby;
    private JButton RegisterButton, btnLogin;
    private ButtonGroup SexGroup;

    private JRadioButton manButton,womanButton;
    private Connection con;
    //Statement stmt;
    //ResultSet rs;
    //连接数据库
    private void connectMyDB() throws SQLException {
        //链接数据库的准备
        String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=MyDataBase";  // 我的数据库名 Test
        String userName="sa";   // 填写你的用户名，我的是sa
        String userPwd="123456";   // 填写你的密码
        //Connection con;
        try{
            //加载驱动程序
            Class.forName(driverName);
            //获得数据库链接
            con = DriverManager.getConnection(dbURL,userName,userPwd);
            //stmt = con.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("数据库链接失败!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("数据库链接失败!");
        }
    }
    //插入用户信息
    private boolean insert (String uname, String upassword, String usex,String ubirthdate, int uage, String uemail,
                                String uhobby) {

        boolean success = false;
        try {
            connectMyDB();
            // 插入用户信息
            String query = "INSERT INTO user (uname, upassword,usex, ubirthdate, uage, uemail, uhobby) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, uname);
            stmt.setString(2, upassword);
            stmt.setString(3, usex);
            stmt.setString(4, ubirthdate);
            stmt.setInt(5, uage);
            stmt.setString(6, uemail);
            stmt.setString(7, uhobby);


            int rowsAffected = stmt.executeUpdate();


            // 插入成功，返回true
            if (rowsAffected > 0) {
                success = true;
            }


            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }
    //检查名字是否重复
    private boolean isExistUsername(String username) {
        boolean exist = false;
        try {
            connectMyDB();
            String query = "SELECT uname FROM [user] WHERE uname=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet result = stmt.executeQuery();
            // 如果查询结果不为空，则表示用户名已存在
            if (result.next()) {
                exist = true;
            }
            stmt.close();
            result.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }
    //查询是否可以登录
    private boolean checkUser(String username, String password) {
        boolean success = false;
        try {
            connectMyDB();

            String query = "SELECT uname,upassword FROM [user] WHERE uname=? AND upassword=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet result = stmt.executeQuery();

            // 如果查询结果不为空，则表示登录信息有效
            if (result.next()) {
                success = true;
            }
            stmt.close();
            result.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }


    public BaseConnection() {

        setTitle("用户注册与登录");

        setSize(400, 400);

        // 边界布局
        setLayout(new BorderLayout());

        JPanel panelCenter = new JPanel();
        panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
        int verticalGap = 2; // 设置垂直间隔

        JLabel lblUsername = new JLabel("用户名:");
        txtuname = new JTextField();
        panelCenter.add(lblUsername);
        panelCenter.add(Box.createVerticalStrut(verticalGap));
        panelCenter.add(txtuname);

        JLabel lblPassword = new JLabel("密码:");
        txtupassword = new JTextField();
        panelCenter.add(lblPassword);
        panelCenter.add(Box.createVerticalStrut(verticalGap));
        panelCenter.add(txtupassword);

        JLabel lblBirthdate = new JLabel("出生日期:");
        txtubirthdate = new JTextField();
        panelCenter.add(lblBirthdate);
        panelCenter.add(Box.createVerticalStrut(verticalGap));
        panelCenter.add(txtubirthdate);

        JLabel lblSex = new JLabel("性别：");

        panelCenter.add(lblSex);
        SexGroup = new ButtonGroup();
        manButton = new JRadioButton("男");
        womanButton = new JRadioButton("女");
        panelCenter.add(manButton);
        panelCenter.add(womanButton);
        SexGroup.add(manButton);
        SexGroup.add(womanButton);
        panelCenter.add(Box.createVerticalStrut(verticalGap));



        JLabel lblAge = new JLabel("年龄:");
        txtuage = new JTextField();
        panelCenter.add(lblAge);
        panelCenter.add(Box.createVerticalStrut(verticalGap));
        panelCenter.add(txtuage);

        JLabel lblEmail = new JLabel("邮箱:");
        txtuemail = new JTextField();
        panelCenter.add(lblEmail);
        panelCenter.add(Box.createVerticalStrut(verticalGap));
        panelCenter.add(txtuemail);

        JLabel lblHobbies = new JLabel("爱好:");
        txtuhobby = new JTextField();
        panelCenter.add(lblHobbies);
        panelCenter.add(Box.createVerticalStrut(verticalGap));
        panelCenter.add(txtuhobby);

        add(panelCenter, BorderLayout.CENTER);

        JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.Y_AXIS));

        RegisterButton = new JButton("注册");
        RegisterButton.addActionListener(this);
        panelSouth.add(RegisterButton);

        panelSouth.add(Box.createVerticalStrut(verticalGap)); // 添加垂直间隔

        btnLogin = new JButton("登录");
        btnLogin.addActionListener(this);
        panelSouth.add(btnLogin);

        add(panelSouth, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == RegisterButton) {

            String uname = txtuname.getText().trim();
            String upassword = txtupassword.getText().trim();

            String usex = "";
            if(manButton.isSelected()){
                usex.concat("男");
            }if(womanButton.isSelected()){
                usex.concat("女");
            }
            String ubirthdate = txtubirthdate.getText().trim();
            int uage = Integer.parseInt(txtuage.getText().trim());
            String uemail = txtuemail.getText().trim();
            String uhobby = txtuhobby.getText().trim();

            if (isExistUsername(uname)) {
                JOptionPane.showMessageDialog(this, "已存在此用户", "注册失败", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (insert(uname, upassword, usex, ubirthdate, uage, uemail, uhobby)) {
                JOptionPane.showMessageDialog(this, "注册成功", "信息", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "注册失败", "注册结果", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == btnLogin) {    //登录
            // 获取用户输入的用户名和密码
            String uname = txtuname.getText().trim();
            String upassword = txtupassword.getText().trim();

            if (checkUser(uname, upassword)) {
                JOptionPane.showMessageDialog(this, "登录成功", "信息", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "登录失败，请检查用户名和密码", "登录结果", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}