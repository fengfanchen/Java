package com.example.demo.utils;

import com.example.demo.vo.ResultVO;

public class ResultUtils {

    public static ResultVO success(Object object){

        ResultVO resultVO =  new ResultVO();
        resultVO.setCode(200);
        resultVO.setMsg("成功");
        resultVO.setData(object);

        return resultVO;
    }

    public static  ResultVO error(Object object){

        ResultVO resultVO =  new ResultVO();
        resultVO.setCode(404);
        resultVO.setMsg("失败");
        resultVO.setData(object);

        return resultVO;
    }
}
