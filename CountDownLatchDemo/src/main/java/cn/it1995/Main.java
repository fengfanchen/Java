package cn.it1995;

import com.sun.corba.se.spi.orbutil.threadpool.Work;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args){

        ExecutorService executorService = Executors.newCachedThreadPool();

        CountDownLatch latch = new CountDownLatch(3);

        Worker w1 = new Worker(latch, "张三");
        Worker w2 = new Worker(latch, "李四");
        Worker w3 = new Worker(latch, "王二");

        Boss boss = new Boss(latch);

        executorService.execute(w1);
        executorService.execute(w2);
        executorService.execute(w3);
        executorService.execute(boss);

        executorService.shutdown();
    }
}
