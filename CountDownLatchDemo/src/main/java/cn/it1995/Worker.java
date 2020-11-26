package cn.it1995;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Worker implements Runnable{

    private CountDownLatch downLatch;
    private String name;

    public Worker(CountDownLatch downLatch, String name){

        this.downLatch = downLatch;
        this.name = name;
    }

    private void doWork(){

        System.out.println(this.name + " 正在干活...");
    }

    public void run() {

        this.doWork();

        try{

            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        }
        catch(InterruptedException e){

            e.printStackTrace();
        }
        this.downLatch.countDown();
        System.out.println(this.name + " 干完活了!");
    }
}
