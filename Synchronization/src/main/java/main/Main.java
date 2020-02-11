package main;

import main.dmDB.DMPtr;
import main.file.ReadFile;

import java.io.IOException;
import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        ReadFile readFile = new ReadFile();
        try {
            readFile.createCMD();

        } catch (IOException e) {

            e.printStackTrace();
        }

        System.out.println("开始操作数据库");

        DMPtr dmPtr = new DMPtr();
        dmPtr.setCmdMap(readFile.getSqlMap());
        System.out.println("内容为：" + dmPtr.getCmdMap());
        dmPtr.runSQLCMD();
        System.out.println("over!");
        dmPtr.closeConnection();
    }
}
