package confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import util.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send2 {

    private static final String QUEUE_NAME = "test_queue_confirm1";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        Connection connection = ConnectionUtils.getConnect();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //生产者调用 confirmSelect 将 channel 设置为 confirm 模式注意
        channel.confirmSelect();

        String msgString = "hello confirm message !";

        for(int i = 0; i < 100; i++){

            channel.basicPublish("", QUEUE_NAME, null, msgString.getBytes());
        }

        if(!channel.waitForConfirms()){

            System.out.println("message send failed !");
        }
        else{

            System.out.println("message send ok !");
        }

        channel.close();
        connection.close();
    }
}
