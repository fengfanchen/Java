package ps;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import util.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Send {

    private static final String EXCHANGE_NAME = "test_exchange_fanout";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnect();
        Channel channel = connection.createChannel();

        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");   //并分配

        String msg = "Hello ps";
        channel.basicPublish(EXCHANGE_NAME, "", null, msg.getBytes());

        System.out.println("Send : " + msg);

        channel.close();
        connection.close();
    }
}
