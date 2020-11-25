package cn.it1995.demo.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DisposeOne implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {

        System.out.println(Thread.currentThread() + ":" + "DisposeOne wants to do sth");
    }
}
