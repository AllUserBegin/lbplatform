package com.erp.config.shiro;


import com.erp.config.redis.RedisConfig;
import com.erp.shiro.OAuth2Realm;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro的配置文件
 *
 * @author Mark sunlightcs@gmail.com
 * @since 3.0.0 2017-09-27
 */
@Configuration
public class ShiroConfig {

    /**
     * shiro 中配置 redis 缓存
     *
     * @return RedisManager
     */
  /*  private RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        // 缓存时间，单位为秒
        //redisManager.setExpire(febsProperties.getShiro().getExpireIn()); // removed from shiro-redis v3.1.0 api
        redisManager.setHost(RedisConfig.gethost());
        redisManager.setPort(RedisConfig.getport());
        redisManager.setPassword(RedisConfig.getpassword());
        redisManager.setTimeout(RedisConfig.gettimeout());
        return redisManager;
    }
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }*/

    @Bean("sessionManager")
    public SessionManager sessionManager(){
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        //sessionManager.setSessionDAO(redisSessionDAO());
        // 设置session超时时间，单位为毫秒
        //sessionManager.setGlobalSessionTimeout(febsProperties.getShiro().getSessionTimeout());

        return sessionManager;
    }

   @Bean("securityManager")
    public SecurityManager securityManager(OAuth2Realm oAuth2Realm, SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(oAuth2Realm);
        securityManager.setSessionManager(sessionManager);

        return securityManager;
    }

        @Bean("shiroFilter")
        public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
            ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
            shiroFilter.setSecurityManager(securityManager);

            //oauth过滤
/*            Map<String, Filter> filters = new HashMap<>();
            filters.put("oauth2", new OAuth2Filter());
            shiroFilter.setFilters(filters);*/


            Map<String, String> filterMap = new LinkedHashMap<>();
            filterMap.put("/webjars/**", "anon");
            filterMap.put("/druid/**", "anon");
            filterMap.put("/app/**", "anon");
            filterMap.put("/SysLogin/login", "anon");
            filterMap.put("/swagger/**", "anon");
            filterMap.put("/v2/api-docs", "anon");
            filterMap.put("/swagger-ui.html", "anon");
            filterMap.put("/swagger-resources/**", "anon");
            filterMap.put("/captcha.jpg", "anon");
            /*filterMap.put("/**", "oauth2");*/
            shiroFilter.setFilterChainDefinitionMap(filterMap);

            return shiroFilter;
        }

    /**
     * LifecycleBeanPostProcessor，这是个DestructionAwareBeanPostProcessor的子类，
     * 负责org.apache.shiro.util.Initializable类型bean的生命周期的，初始化和销毁。
     * 主要是AuthorizingRealm类的子类，以及EhCacheManager类。
     */
    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * DefaultAdvisorAutoProxyCreator，Spring的一个bean，由Advisor决定对哪些类的方法进行AOP代理。
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator proxyCreator = new DefaultAdvisorAutoProxyCreator();
        proxyCreator.setProxyTargetClass(true);
        return proxyCreator;
    }

    /**
     * AuthorizationAttributeSourceAdvisor，shiro里实现的Advisor类，
     * 内部使用AopAllianceAnnotationsAuthorizingMethodInterceptor来拦截用以下注解的方法。
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

}