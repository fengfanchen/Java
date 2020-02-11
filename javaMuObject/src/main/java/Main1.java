import java.util.LinkedList;
import java.util.Queue;

class TaskQueue{

    final Queue<String> queue = new LinkedList<String>();

    public synchronized String getTask() throws InterruptedException {

        while(this.queue.isEmpty()){

            this.wait();
        }

        return queue.remove();
    }

    public synchronized void addTask(String name){

        this.queue.add(name);
        this.notifyAll();
    }
}

class WorkerThread extends Thread{

    TaskQueue taskQueue;

    public WorkerThread(TaskQueue taskQueue){

        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {

        while(!isInterrupted()){

            String name = "";

            try{

                name = taskQueue.getTask();
            }
            catch (InterruptedException e){

                e.printStackTrace();
            }
            String result = ">" + name;
            System.out.println(result);
        }
    }
}

public class Main1 {

    public static void main(String[] args) throws Exception {

        TaskQueue taskQueue = new TaskQueue();
        WorkerThread worker = new WorkerThread(taskQueue);
        worker.start();
        taskQueue.addTask("AAA");
        Thread.sleep(1000);
        taskQueue.addTask("BBB");
        Thread.sleep(1000);
        taskQueue.addTask("CCC");
        worker.interrupt();
        worker.join();
        System.out.println("END");
    }
}
