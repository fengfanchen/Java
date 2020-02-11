import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter{

    private Lock lock = new ReentrantLock();
    private int value = 0;

    public void add(int m){

        lock.lock();
        try{

            this.value += m;
        }
        finally {

            lock.unlock();
        }
    }

    public void inc() throws InterruptedException {

        if(lock.tryLock(1, TimeUnit.SECONDS)){

            try{

                this.value += 1;
            }
            finally {

                lock.unlock();
            }
        }
    }

    public void dec(int m){

        lock.lock();
        try{

            this.value -= m;
        }
        finally {

            lock.unlock();
        }
    }

    public int get(){

        lock.lock();
        try{

            return this.value;
        }
        finally {

            lock.unlock();
        }
    }
}

public class Main2 {

    final static int LOOP = 1000;
    public static void main(String[] args) throws InterruptedException {

        final Counter counter = new Counter();
        Thread t1 = new Thread(){

            @Override
            public void run() {

                for(int i = 0; i < LOOP; i++){

                    counter.add(1);
                }
            }
        };
        Thread t2 = new Thread(){

            @Override
            public void run() {

                for(int i = 0; i < LOOP; i++){

                    counter.dec(1);
                }
            }
        };
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.get());
        System.out.println("END");
    }
}
