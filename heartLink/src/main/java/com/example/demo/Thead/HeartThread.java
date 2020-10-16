package com.example.demo.Thead;

import com.example.demo.service.JDBCService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

public class HeartThread extends Thread {

    @Autowired
    JDBCService jdbcService;

    private String heartSqlCmd = null;

    public void setHeartSqlCmd(String heartSqlCmd) {

        this.heartSqlCmd = heartSqlCmd;
    }

    @SneakyThrows
    @Override
    public void run() {

        while (true){

            try{

                jdbcService.executeSQLCmd(heartSqlCmd);
                System.out.println(Thread.currentThread() + ":" + "连接正常");
            }
            catch (Exception e){

                //e.printStackTrace();
                //记录日志
                //重连
                System.out.println(Thread.currentThread() + ":" + "心跳检测断开正在重连");
                JDBCService.reConnection();
            }
            Thread.sleep(1000 );
        }
    }
}
