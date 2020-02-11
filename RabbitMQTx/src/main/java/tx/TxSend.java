package tx;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import util.ConnectionUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class TxSend {

    private static final String QUEUE_NAME = "test_queue_tx";

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = ConnectionUtils.getConnect();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String msgString = "hello tx message!";

        try{

            channel.txSelect();
            channel.basicPublish("", QUEUE_NAME, null, msgString.getBytes());
            //int a = 1 / 0;
            channel.txCommit();
            System.out.println("send : " + msgString + " finished!");
        } catch (Exception e){

            channel.txRollback();
            System.out.println("send message txRollback");
        }

        channel.close();
        connection.close();
    }
}
