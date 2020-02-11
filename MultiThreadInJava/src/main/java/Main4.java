class MyThread3 extends Thread{

    @Override
    public void run() {

        while(!isInterrupted()){

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main4 {

    public static void main(String[] args){

    }
}
