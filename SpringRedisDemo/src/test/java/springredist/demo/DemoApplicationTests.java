package springredist.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {


        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        RedisTemplate redisTemplate = (RedisTemplate) ac.getBean("redisTemplate");


        /***
         *  操作String
         */
        ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("hobby", "eat");
        System.out.println(valueOperations.get("hobby"));

        /***
         * 操作List
         */
        ListOperations listOperations = redisTemplate.opsForList();
        System.out.println(listOperations);
    }

}
