package com.jk.shiro;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
public class ShiroConfig {

    //配置shiro拦截
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean sfb = new ShiroFilterFactoryBean();
        sfb.setSecurityManager(securityManager);//添加securityManager，要不然没法认证
        // ShiroFilterFactoryBean自带过滤和拦截。以及转发请求和返回页面
        sfb.setLoginUrl("/toLoginHouTai");//设置登录页面的地址，默认login页面，请求后台路径

        //拦截的规则 K:路径 v:拦截还是不拦截
        //- anon:所有url都都可以匿名访问
        //- authc: 需要认证才能进行访问
        //- logout :注销
        Map<String , String> map = new LinkedHashMap<>();
        map.put("/logout","logout");//注销, 路径和value中的logout一定要一致，这是shiro提供的路径地址和value值
        map.put("/toLoginHouTai","anon");
        map.put("/login","anon");
        //map.put("/hello","anon");

        /*map.put("/toRegister","anon");
        map.put("/login","anon");
        map.put("/toShoppingCart","anon");
        map.put("/toMain","anon");
        map.put("/toXiangQing1","anon");
        map.put("/toXiangQing2","anon");
        map.put("/toXiangQing3","anon");
        map.put("/toShiZhanKeCheng","anon");
        map.put("/toMianFeiKeCheng","anon");
        map.put("/toKingZhiWei","anon");
        map.put("/toWIKI","anon");*/

        //放开静态资源
        map.put("/js/**","anon");
        map.put("/css/**","anon");
        map.put("/images/**","anon");
        map.put("/img/**","anon");
        //其他的都拦截
        //map.put("/**","authc");
        map.put("/toMainHouTai","authc");
        // 将自定义的过滤器设置到shiro过滤器链中
        sfb.setFilterChainDefinitionMap(map);
        return sfb;
    }

    @Bean
    public SecurityManager securityManager(MyRealm myRealm){
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        dwsm.setRealm(myRealm());
        // 设置缓存管理器为 ehcache
        dwsm.setCacheManager(ehCacheManager());
        return dwsm;
    }

    @Bean
    public MyRealm myRealm(){
        MyRealm myRealm = new MyRealm();
        // realm中设置盐的凭证器
        myRealm.setCredentialsMatcher(credentialsMatcher());
        return myRealm;
    }

    // 加盐 凭证器
    @Bean
    public HashedCredentialsMatcher credentialsMatcher(){
        HashedCredentialsMatcher hcm = new HashedCredentialsMatcher();
        hcm.setHashAlgorithmName("MD5"); //加密方式 MD5("123")
        hcm.setHashIterations(2); //散列次数   MD5(MD5(MD5(MD5(MD5("123")))))
        return hcm;
    }

    //用户授权信息Cache, 采用EhCache
    @Bean
    public EhCacheManager ehCacheManager(){
        EhCacheManager ehCacheManager = new EhCacheManager();
//        ehCacheManager.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return ehCacheManager;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

    // 未授权页面
    @Bean
    public SimpleMappingExceptionResolver
    createSimpleMappingExceptionResolver() {
        SimpleMappingExceptionResolver r = new SimpleMappingExceptionResolver();
        Properties mappings = new Properties();
        mappings.setProperty("UnauthorizedException","/nopower");
        r.setExceptionMappings(mappings);  // None by default
        return r;
    }


}
