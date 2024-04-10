package cn.demo;

import cn.demo.test.DMTest;
import cn.demo.test.MySQLTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestMain  implements CommandLineRunner {

    @Autowired
    DMTest dmTest;

    @Autowired
    MySQLTest mySQLTest;

    public static void main(String[] args) {
        SpringApplication.run(TestMain.class, args);
    }

    public void run(String... args) throws Exception {

        System.out.println(dmTest.test());
        System.out.println(mySQLTest.test());
    }
}
