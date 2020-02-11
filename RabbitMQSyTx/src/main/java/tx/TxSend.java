package tx;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import util.ConnectionUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

public class TxSend {

    private static final String QUEUE_NAME = "test_queue_confirm3";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        Connection connection = ConnectionUtils.getConnect();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        //生产者调用confirmSelect 将 channel 设置为 confirm 模式
        channel.confirmSelect();

        //未确认的标识
        final SortedSet<Long> confirmSet = Collections.synchronizedSortedSet(new TreeSet<Long>());

        channel.addConfirmListener(new ConfirmListener() {

            //ACK
            public void handleAck(long l, boolean b) throws IOException {

                if(b){

                    System.out.println("> handleAck multiple!");    //多条
                    confirmSet.headSet(l + 1).clear();
                }
                else{

                    System.out.println("> handleAck multiple false!");  //单条
                    confirmSet.remove(l);
                }
            }

            //Nack 回执有问题的
            public void handleNack(long l, boolean b) throws IOException {

                if(b){

                    System.out.println("> handleNack multiple!");   //多条
                    confirmSet.headSet(l + 1).clear();
                }
                else{

                    System.out.println("> handleNack multiple false!"); //单条
                    confirmSet.remove(l);
                }
            }
        });

        String msgStr = "Hello World!";

        while (true){

            long seqNo = channel.getNextPublishSeqNo();
            channel.basicPublish("", QUEUE_NAME, null, msgStr.getBytes());
            confirmSet.add(seqNo);

        }
    }
}
