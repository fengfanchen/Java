package cn.it1995;

import java.util.concurrent.CountDownLatch;

public class Boss implements Runnable{

    private CountDownLatch downLatch;

    public Boss(CountDownLatch downLatch){

        this.downLatch = downLatch;
    }


    public void run() {

        System.out.println("老版在等待所有工人干完活....");

        try {
            this.downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("工人都干完活了，老版开始检查");
    }
}
