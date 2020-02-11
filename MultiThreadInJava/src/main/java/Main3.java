class MyThread2 extends Thread{

    @Override
    public void run() {

        while(!isInterrupted()){

            System.out.println("[" + Thread.currentThread().getId() + "]" + " " + "Hello");
        }
    }
}

public class Main3 {

    public static void main(String[] args) throws InterruptedException {

        MyThread2 myThread = new MyThread2();
        myThread.start();
        Thread.sleep(1000);
        myThread.interrupt();
    }
}
