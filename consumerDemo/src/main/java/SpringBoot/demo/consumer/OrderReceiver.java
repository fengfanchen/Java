package SpringBoot.demo.consumer;

import SpringBoot.demo.entity.Order;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrderReceiver {


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "order-queue", durable = "true"),
            exchange = @Exchange(name = "order-exchange", type = "topic"),
            key = "order.#"))
    @RabbitHandler
    public void onOrderMessage(@Payload Order order,
                               @Headers Map<String, Object> headers,
                               Channel channel //手工签收需要rabbitMQ的通道
                               ) throws Exception{

        //消费者操作
        System.out.println("--------------收到消息,开始消费--------------");
        System.out.println("订单ID：" + order.getId());


        //告诉RabbitMQ我已经签收了
        long deliveryTag = (long)headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(deliveryTag, false);   //false为不支持批量签收
    }


}
