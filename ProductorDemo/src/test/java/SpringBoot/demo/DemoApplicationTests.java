package SpringBoot.demo;

import SpringBoot.demo.entity.Order;
import SpringBoot.demo.produce.OderSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    private OderSender oderSender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testSend1()throws Exception{

        Order order = new Order();
        order.setId("20180618000000000002");
        order.setName("测试订单2");
        order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
        oderSender.send(order);
    }

}
