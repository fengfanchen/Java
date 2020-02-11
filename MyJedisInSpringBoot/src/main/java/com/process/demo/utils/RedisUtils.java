package com.process.demo.utils;

import com.process.demo.spring.SpringBeanHolder;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RedisUtils {

    private static JedisPool jedisPool = null;

    static {

        jedisPool = (JedisPool) SpringBeanHolder.getBean("jedisPool");
    }

    public static Set<String> getKeysListByVagueWord(String key){

        Jedis jedis = jedisPool.getResource();
        Set<String> keys = jedis.keys("*" + key);
        jedis.close();
        return keys;
    }

    public static Map<String, String> getHGetAllByKey(String key){

        Jedis jedis = jedisPool.getResource();

        Map<String, String> map = jedis.hgetAll(key);
        jedis.close();
        return map;
    }

    public static Set<String> getHKeysByKey(String key){

        Jedis jedis = jedisPool.getResource();
        Set<String> hkeys = jedis.hkeys(key);
        jedis.close();
        return hkeys;
    }

    public static List<String> getHValueByKey(String key){

        Jedis jedis = jedisPool.getResource();
        List<String> hvals = jedis.hvals(key);
        jedis.close();
        return hvals;
    }

    public static void insertTest(){

        Jedis jedis = jedisPool.getResource();
        String set = jedis.set("key1", "测试");
        System.out.println(set);
        jedis.close();
    }


    public static void getTest(){

        Jedis jedis = jedisPool.getResource();
        String set = jedis.get("key1");
        System.out.println(set);
        jedis.close();
    }
}
