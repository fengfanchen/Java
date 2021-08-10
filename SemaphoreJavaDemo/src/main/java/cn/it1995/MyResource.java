package cn.it1995;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

public class MyResource {

    private static Semaphore semaphore = new Semaphore(1);
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式

    public static void todoSth(){

        try {

            semaphore.acquire(1);

            Date startDate = new Date();
            String time = sdf.format(startDate);

            System.out.println(time + "->" + Thread.currentThread() + " 开始处理业务");
            Thread.sleep(5 * 1000);

            Date endDate = new Date();
            time = sdf.format(endDate);
            System.out.println(time + "->" + Thread.currentThread() + " 处理业务完成");
        }
        catch (Exception e){

            e.printStackTrace();
        }
        finally {

            semaphore.release(1);
        }
    }
}
