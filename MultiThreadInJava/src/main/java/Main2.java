class MyThread extends Thread{

    String name;

    public MyThread(String name){

        this.name = name;
    }

    @Override
    public void run() {

        for(int i = 0; i < 5; i++){

            System.out.println("[" + Thread.currentThread().getId() + "]" + " " + name);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main2 {

    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread("线程");
        System.out.println("线程");
        myThread.start();
        myThread.join();    //等待myThread执行结束
        System.out.println("END");
    }
}
