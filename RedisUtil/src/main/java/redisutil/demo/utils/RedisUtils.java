package redisutil.demo.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisUtils {

    private static JedisPool jedisPool = null;

    static {

        jedisPool = (JedisPool)SpringBeanHolder.getBean("jedisPool");
    }

    public static void set(String key, String value){

        Jedis jedis = null;

        try {

            if(jedis == null){

                jedis = jedisPool.getResource();
                jedis.set(key, value);
            }
        }
        catch (Exception e){

            e.printStackTrace();
        }
        finally {

            jedis.close();
        }
    }

    public static void set(String key, String value, int expireTime){

        Jedis jedis = null;

        try {

            if(jedis == null){

                jedis = jedisPool.getResource();
                jedis.set(key, value);
                jedis.expire(key, expireTime);
            }
        }
        catch (Exception e){

            e.printStackTrace();
        }
        finally {

            jedis.close();
        }
    }

    public static String get(String key, String value){

        return null;
    }


}
