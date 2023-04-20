package 高级Java程序开发.第六次作业.MVC设计;

import java.sql.*;

public class DataControl {
    private Connection connection;

    public boolean checkUsernameExist(String username) {
        boolean exist = false;
        try {
            connectDB();
            String query = "SELECT * FROM MyUser WHERE username=?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                exist = true;
            }
            closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }

    public void connectDB() throws SQLException {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=JDBCTest";
        String user = "zh";
        String password = "1234567890";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(url, user, password);
    }

    public void closeDB() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public boolean insertUser(String username, String password, String birthdate, int age, String email,
                              String hobbies) {
        boolean success = false;
        try {
            connectDB();
            String query = "INSERT INTO MyUser (username, password, birthdate, age, email, hobbies) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, birthdate);
            stmt.setInt(4, age);
            stmt.setString(5, email);
            stmt.setString(6, hobbies);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
            closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    public boolean checkUser(String username, String password) {
        boolean valid = false;
        try {
            connectDB();
            String query = "SELECT * FROM MyUser WHERE username=? AND password=?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                valid = true;
            }
            closeDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valid;
    }
}
