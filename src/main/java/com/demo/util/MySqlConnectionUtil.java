package com.demo.util;

import com.demo.dao.EmployeeDao;
import com.demo.dao.impl.EmployeeDaoImpl;
import com.demo.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MySqlConnectionUtil {
    private static final ResourceBundle rb =ResourceBundle.getBundle("DatabaseInformation");
    private static final String user_name= rb.getString("datasource.user");
    private static final String pass_word = rb.getString("datasource.password");
    private static final String URL=rb.getString("datasource.url");
    private static final String DriverName=rb.getString("datasource.driver");
    public static Connection getConnection(){
        try {
            Class.forName(DriverName);
            return DriverManager.getConnection(URL,user_name,pass_word);
        } catch (ClassNotFoundException e) {
                return null;
        }   catch (SQLException e){
            return null;
        }
    }
    public static void disConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void executableSql(String sql) throws Exception{
        Connection connect =getConnection();
        Statement stmt = connect.createStatement();
        stmt.executeUpdate(sql);
    }
    public ResultSet selectData(String sql) throws Exception{
        Connection connect = getConnection();
        Statement stmt = connect.createStatement();
        ResultSet rs =stmt.executeQuery(sql);
        return rs;
    }

}
