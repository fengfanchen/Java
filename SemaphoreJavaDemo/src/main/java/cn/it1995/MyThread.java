package cn.it1995;

public class MyThread implements Runnable {


    public void run() {

        while (true) {

            try {

                MyResource.todoSth();
                Thread.sleep( 1 * 1000);
            }
            catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
}
