package com.process.demo.service.imple;

import com.process.demo.service.RedisService;
import com.process.demo.utils.RedisUtils;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.*;

@Service
public class RedisServiceImpl implements RedisService {

    private List<Map<String, String>> getRedisData(Set<String> node){

        List<Map<String, String>> ret = new ArrayList<>();

        for(String item : node){

            Map<String, String> hGetAllByKey = RedisUtils.getHGetAllByKey(item);
            ret.add(hGetAllByKey);
        }

        return ret;
    }

    @Override
    public List<Map<String, String>> getit1995_1(){

        Set<String> node = RedisUtils.getKeysListByVagueWord("it1995_1");
        return getRedisData(node);
    }

    @Override
    public List<Map<String, String>> getit1995_2(){

        Set<String> appinfo = RedisUtils.getKeysListByVagueWord("it1995_2");
        List<Map<String, String>> redisData = getRedisData(appinfo);
        return redisData;
    }

    @Override
    public List<Map<String, String>> getit1995_3(){

        Set<String> procinfo = RedisUtils.getKeysListByVagueWord("it1995_3");
        List<Map<String, String>> redisData = getRedisData(procinfo);
        return redisData;
    }

}
