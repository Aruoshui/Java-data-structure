package 高级Java程序开发.第五次作业;

import java.sql.*;
import javax.swing.*;

public class UserRegistrationAndLogin {
    public static void main(String[] args) {
        // Replace with your database connection string and credentials
        String connectionString = "jdbc:sqlserver://localhost:1433;databaseName=Test";
        String username = "zh";
        String password = "1234567890";

        try (Connection conn = DriverManager.getConnection(connectionString, username, password)) {
            // Create user table if it doesn't exist
            String createTableSql = "IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='user' AND xtype='U') CREATE TABLE user (username VARCHAR(255) PRIMARY KEY, password VARCHAR(255), birthdate DATE, age INT, email VARCHAR(255), hobbies VARCHAR(255))";
            try (Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(createTableSql);
            }

            // Register user
            String registerUsername = JOptionPane.showInputDialog("Enter username to register:");
            String registerPassword = JOptionPane.showInputDialog("Enter password to register:");
            String registerBirthdate = JOptionPane.showInputDialog("Enter birthdate to register (YYYY-MM-DD):");
            int registerAge = Integer.parseInt(JOptionPane.showInputDialog("Enter age to register:"));
            String registerEmail = JOptionPane.showInputDialog("Enter email to register:");
            String registerHobbies = JOptionPane.showInputDialog("Enter hobbies to register:");

            String checkUserSql = "SELECT * FROM user WHERE username=?";
            try (PreparedStatement pstmt = conn.prepareStatement(checkUserSql)) {
                pstmt.setString(1, registerUsername);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Registration failed: username already exists.");
                } else {
                    String insertUserSql = "INSERT INTO user (username, password, birthdate, age, email, hobbies) VALUES (?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement pstmt2 = conn.prepareStatement(insertUserSql)) {
                        pstmt2.setString(1, registerUsername);
                        pstmt2.setString(2, registerPassword);
                        pstmt2.setDate(3, Date.valueOf(registerBirthdate));
                        pstmt2.setInt(4, registerAge);
                        pstmt2.setString(5, registerEmail);
                        pstmt2.setString(6, registerHobbies);
                        pstmt2.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Registration successful.");
                    }
                }
            }

            // Login user
            String loginUsername = JOptionPane.showInputDialog("Enter username to login:");
            String loginPassword = JOptionPane.showInputDialog("Enter password to login:");

            String loginUserSql = "SELECT * FROM user WHERE username=? AND password=?";
            try (PreparedStatement pstmt = conn.prepareStatement(loginUserSql)) {
                pstmt.setString(1, loginUsername);
                pstmt.setString(2, loginPassword);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login successful.");
                } else {
                    JOptionPane.showMessageDialog(null, "Login failed: invalid username or password.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
