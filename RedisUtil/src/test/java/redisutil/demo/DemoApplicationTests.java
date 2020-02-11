package redisutil.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import redisutil.demo.utils.RedisUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {

        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        RedisUtils.set("IT1995", "IT1995");
        RedisUtils.set("IT1995Time", "heheda", 100);
    }

}
