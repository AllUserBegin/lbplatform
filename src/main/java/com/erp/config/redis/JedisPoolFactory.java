package com.erp.config.redis;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableCaching
public class JedisPoolFactory {

    private Logger logger = LoggerFactory.getLogger(JedisConfig.class);

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    //连接池中的最大空闲连接
    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    //连接池中的最小空闲连接
    @Value("${spring.redis.jedis.pool.min-idle}")
    private int minIdle;

    //连接池最大阻塞等待时间（使用负值表示没有限制）
    @Value("${spring.redis.jedis.pool.max-wait}")
    private int maxWaitMillis;

    //连接池最大连接数（使用负值表示没有限制）
    @Value("${spring.redis.jedis.pool.max-active}")
    private int maxActive;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.block-when-exhausted}")
    private boolean  blockWhenExhausted;

    @Bean
    public JedisPool getJedisPool() throws Exception{
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        // 是否启用pool的jmx管理功能, 默认true
        jedisPoolConfig.setJmxEnabled(true);

        JedisPool pool = new JedisPool(jedisPoolConfig, host,port,timeout,password);
   /*     String ping= pool.getResource().ping();
        pool.getResource().set("aa","bb");*/
        return pool;
    }

}