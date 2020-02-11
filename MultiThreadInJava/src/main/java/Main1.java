
class Thread1 extends Thread{

    String name;
    public Thread1(String name){

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


public class Main1 {

    public static void main(String[] args){

        Thread1 t1 = new Thread1("线程1");
        t1.start();
        Thread1 t2 = new Thread1("线程2");
        t2.start();
        System.out.println("Over!");

    }
}
