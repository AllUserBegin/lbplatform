package com.erp.config.redis;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class RedisConfig {

    @Value("${spring.redis.host}")
    private static String host;

    public static String  gethost()
    {
        return  host;
    }

    @Value("${spring.redis.port}")
    private static int port;

    public static int  getport()
    {
        return  port;
    }

    @Value("${spring.redis.timeout}")
    private static int timeout;

    public static int  gettimeout()
    {
        return  timeout;
    }

    //连接池中的最大空闲连接
    @Value("${spring.redis.jedis.pool.max-idle}")
    private  int maxIdle;

    //连接池中的最小空闲连接
    @Value("${spring.redis.jedis.pool.min-idle}")
    private  int minIdle;

    //连接池最大阻塞等待时间（使用负值表示没有限制）
    @Value("${spring.redis.jedis.pool.max-wait}")
    private  int maxWaitMillis;

    //连接池最大连接数（使用负值表示没有限制）
    @Value("${spring.redis.jedis.pool.max-active}")
    private  int maxActive;

    @Value("${spring.redis.password}")
    private static String password;

    public static String  getpassword()
    {
        return  password;
    }

    @Value("${spring.redis.block-when-exhausted}")
    private  boolean  blockWhenExhausted;


}
