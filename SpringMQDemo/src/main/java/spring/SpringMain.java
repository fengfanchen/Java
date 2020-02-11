package spring;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

    public static void main(String[] args) throws InterruptedException {

        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");

        //RabbitMQ模板
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);

        //发送消息
        template.convertAndSend("Hello world! spring");
        Thread.sleep(1000);

        //容器消耗
        ctx.destroy();
    }
}
