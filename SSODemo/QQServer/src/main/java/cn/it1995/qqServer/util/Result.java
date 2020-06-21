package cn.it1995.qqServer.util;

import java.util.HashMap;

public class Result extends HashMap {

    public static String SUCCESS_CODE = "200";
    public static String ERROR_CODE = "500";
    public static String DATA_KEY = "data";
    public static String MSG_KEY = "msg";

    private static Result ok(){

        return new Result();
    }

    public Result set(String key, Object object){

        super.put(key, object);
        return this;
    }

    public Result success(String msg, Object object){

        return Result.ok()
                .set("code", Result.SUCCESS_CODE)
                .set(Result.MSG_KEY, msg);
    }

    public Result data(Object object){

        return this.set("data", object);
    }

    public static Result success(){

        return Result.ok().set("code", Result.SUCCESS_CODE);
    }

}
