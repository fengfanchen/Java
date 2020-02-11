class MyThread5 extends Thread{

    public volatile boolean running = true;

    @Override
    public void run() {


        while(running){

            System.out.println("Hello");

            try {

                Thread.sleep(100);
            }
            catch (InterruptedException e) {

                e.printStackTrace();
                System.out.println("InterruptedException");
                break;
            }
        }
    }
}

public class Main5 {

    public static void main(String[] args) throws InterruptedException {

        MyThread5 myThread5 = new MyThread5();
        myThread5.start();
        Thread.sleep(1000);
        myThread5.running = false;
        System.out.println("end");
    }
}
