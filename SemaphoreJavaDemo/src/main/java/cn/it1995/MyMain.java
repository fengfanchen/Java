package cn.it1995;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyMain {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++){

            threadPool.execute(new MyThread());
        }
    }
}
