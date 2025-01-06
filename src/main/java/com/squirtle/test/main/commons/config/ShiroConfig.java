package com.squirtle.test.main.commons.config;

import com.squirtle.test.main.commons.config.realm.MyShiroRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author squirtle
 * @version 1.0.0
 * @describe shiro配置
 * @date 2024/12/05
 */
@Configuration
public class ShiroConfig {

    @Bean("securityManager")
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //配置realm
        securityManager.setRealm(myShiroRealm());
        return securityManager;
    }

    @Bean
    public MyShiroRealm myShiroRealm() {
        return new MyShiroRealm();
    }

    /**
     * @param securityManager 安全管理
     * @return {@link ShiroFilterFactoryBean }
     * @Description: shiro内置过滤器实现权限相关拦截器
     * @see SecurityManager
     * @see ShiroFilterFactoryBean
     */
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
//        //指定登录页面
//        shiroFilterFactoryBean.setLoginUrl("/login");
//        //登录成功后跳转的链接
//        shiroFilterFactoryBean.setSuccessUrl("/success");
//        //未授权界面
//        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");
        //配置过滤器，过滤器也可以自己实现OAuth2Filter
//        Map<String, Filter> filters = new HashMap<>();
////             filters.put("localFilter", new LocaleFilter());
//        filters.put("oauth2", new OAuth2Filter());
//        shiroFilterFactoryBean.setFilters(filters);
//        //拦截器，配置不会被拦截的链接，顺序判断
        Map<String, String> filterMap = new LinkedHashMap<>();
//        //所有匿名用户均可访问到Controller层的该接口下
//        filterChainDefinitionMap.put("/login", "anon");
//        filterChainDefinitionMap.put("/login.html", "anon");
//        //所有请求都要经过认证才可以访问
//        filterChainDefinitionMap.put("/**", "authc");
//        //TODO: anon:无需认证可以访问；authc:必须认证才可以访问；user:如果使用rememberMe的功能可以直接访问；perms:该资源必须得到资源权限才可以访问；role:该资源必须得到角色权限才可以访问
        filterMap.put("/safeRest/smartBc/app/user/doLogin", "anon");
        filterMap.put("/openRest/oauth2/logout", "oauth2");
        filterMap.put("/openRest/oauth2/checkPermission", "oauth2");
        filterMap.put("/openRest/**", "anon");
        filterMap.put("/websocket/**", "anon");
        filterMap.put("/web_logo/**", "anon");

        filterMap.put("/", "anon");
        filterMap.put("/**/*.css", "anon");
        filterMap.put("/**/*.js", "anon");
        filterMap.put("/**/*.html", "anon");
        filterMap.put("/**/*.htm", "anon");
        filterMap.put("/**/*.png", "anon");
        filterMap.put("/**/*.ico", "anon");
        filterMap.put("/**/captcha.jpg", "anon");
        filterMap.put("/**/*.jpg", "anon");
        filterMap.put("/**/*.mp3", "anon");
        filterMap.put("/**/*.gif", "anon");
        filterMap.put("/fonts/**", "anon");
        filterMap.put("/android/**", "anon");
        filterMap.put("/plugins/**", "anon");
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/druid/**", "anon");
        filterMap.put("/i18n/**", "anon");

        filterMap.put("/**/*.map", "anon");
        filterMap.put("/**/*.eot", "anon");
        filterMap.put("/**/*.ttf", "anon");
        filterMap.put("/**/*.woff", "anon");
        filterMap.put("/**/*.woff2", "anon");

        //swagger配置
        filterMap.put("/swagger**", "anon");
        filterMap.put("/v2/api-docs", "anon");
        filterMap.put("/swagger-resources/configuration/ui", "anon");

        //actuator监控配置
        filterMap.put("/actuator/**", "anon");

        filterMap.put("/safeRest/**", "oauth2");
        filterMap.put("/**", "oauth2");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
