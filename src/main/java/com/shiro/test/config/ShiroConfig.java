package com.shiro.test.config;

import com.shiro.test.shiro.JWTFilter;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {
    /**
     * 创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        //设置SecurityManager
        factoryBean.setSecurityManager(securityManager);

        Map<String, Filter> filterMap = new HashMap<>();
        filterMap.put("jwt", new JWTFilter());
        factoryBean.setFilters(filterMap);
        /*
         * anon：无需认证就可以访问
         * authc：必须认证了才能访问
         * user：必须用有了 记住我 功能才能用
         * perms：拥有对某个资源的权限才能访问
         * role：拥有某个角色权限才能访问
         */
        //对于没有登录的请求码拦截后返回JSON的状态信息码，
//        Map<String, Filter> filterMap = new LinkedHashMap<>();
//        factoryBean.setFilters(filterMap);


        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/doc.html", "anon");
        filterChainDefinitionMap.put("/configuration/ui", "anon");
        filterChainDefinitionMap.put("/swagger-resources", "anon");
        filterChainDefinitionMap.put("/swagger-ui.html", "anon");
        filterChainDefinitionMap.put("/v2/api-docs", "anon");
        filterChainDefinitionMap.put("/v2/api-docs-ext", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/redis/**", "anon");
        filterChainDefinitionMap.put("/test/user/login", "anon");


        filterChainDefinitionMap.put("/**", "jwt");

        factoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        //配置Shiro内置过滤器
        return factoryBean;
    }

    /**
     * 创建SecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("UserRealm") UserRealm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置Realm
        securityManager.setRealm(realm);
        return securityManager;
    }
    /**
     * Realm
     */
    @Bean(name = "UserRealm")
    public UserRealm getRealm(){
        return new UserRealm();
    }


    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    @DependsOn(value = "lifecycleBeanPostProcessor")
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
