package main.dmDB;

import lombok.Data;

import java.sql.*;
import java.util.Map;

public class DMPtr {

    private Connection connection = null;

    Map<Integer, String> cmdMap;

    public DMPtr() throws SQLException, ClassNotFoundException {


        String jdbcString = "dm.jdbc.driver.DmDriver";
        String urlString = "jdbc:dm://127.0.0.1:5236";

        String userName = "SYSDBA";
        String passWord = "SYSDBA";

        Class.forName(jdbcString);

        //连接
        connection = DriverManager.getConnection(urlString, userName, passWord);
    }


    /**
     * 打印数据
     * @param rs
     * @throws SQLException
     */
    private static void displayResultSet(ResultSet rs) throws SQLException {

        // 取得结果集元数据
        ResultSetMetaData rsmd = rs.getMetaData();
        // 取得结果集所包含的列数
        int numCols = rsmd.getColumnCount();
        //列头
        for (int i = 1; i <= numCols; i++) {
            if (i > 1) {
                System.out.print(",");
            }
            System.out.print(rsmd.getColumnLabel(i));
        }
        System.out.println("");

        //所有数据
        while (rs.next()) {
            for (int i = 1; i <= numCols; i++) {
                if (i > 1) {
                    System.out.print(",");
                }
                // 普通字段
                System.out.print(rs.getString(i));
            }
            System.out.println("");
        }
    }

    public Map<Integer, String> getCmdMap() {
        return cmdMap;
    }

    public void setCmdMap(Map<Integer, String> cmdMap) {
        this.cmdMap = cmdMap;
    }

    /***
     * 运行SQL命令
     */
    public void runSQLCMD() throws SQLException {

        for(int i = 0; i < cmdMap.size(); i++){

            String queryStr = cmdMap.get(i);
            System.out.println("开始执行：" + queryStr);
            Statement statement = connection.createStatement();
            System.out.println("影响的行数:" + statement.executeUpdate(queryStr));
            statement.close();
        }
    }

    /***
     * 关闭连接
     */
    public void closeConnection() throws SQLException {

        connection.close();
    }
}
