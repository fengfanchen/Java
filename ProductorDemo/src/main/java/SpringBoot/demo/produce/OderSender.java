package SpringBoot.demo.produce;

import SpringBoot.demo.entity.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OderSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(Order order) throws Exception{

        CorrelationData correlationData = new CorrelationData();
        correlationData.setId(order.getMessageId());


        rabbitTemplate.convertAndSend("order-exchange",     //exchange
                "order.abcd",       //routingKey
                order,                          //消息体
                correlationData);               //correlationData消息唯一ID
    }
}
