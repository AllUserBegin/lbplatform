package com.erp.config.redis;

public class RedisKeys {


    /*
      用户登录信息
   */
    public static String getUserLoginInfo(String key){
        return "lb.login." + key;
    }


    /*
     用户权限
     */
    public static String getUserPermissions(Long id){
        return "lb.UserPerm." + id;
    }

    public static String getSysConfigKey(String key){
        return "sys:config." + key;
    }

    public static String getShiroSessionKey(String key){
        return "0:" + key;
    }
}