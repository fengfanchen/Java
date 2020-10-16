package com.example.demo.service;

import com.example.demo.exception.StrException;
import org.springframework.stereotype.Service;

import java.sql.*;

@Service
public class JDBCService {

    static String urlString = "jdbc:oracle:thin:@//192.168.1.102:1521/orcl";

    static String userName = "xxxxxx";
    static String passWord = "xxxxxx";

    private static Connection connection = null;
    private static Statement stmt = null;

    static {



        try {

            //连接
            connection = DriverManager.getConnection(urlString, userName, passWord);
            stmt = connection.createStatement();
        } catch (SQLException e) {

            //记录日志
            e.printStackTrace();
        }
    }

    public static void reConnection(){


        try {

            //连接
            connection = DriverManager.getConnection(urlString, userName, passWord);
            stmt = connection.createStatement();
        } catch (SQLException e) {

            //记录日志
            e.printStackTrace();
        }
    }

    public void executeSQLCmd(String sql) throws SQLException, StrException {

        if(connection == null){

            throw new StrException("connection为null，赶紧退出");
        }

        if(stmt == null){

            throw new StrException("stmt为null，赶紧退出");
        }

        ResultSet rs = stmt.executeQuery(sql);
        if(rs == null){

        }
        else{

            rs.close();
        }
    }
}
