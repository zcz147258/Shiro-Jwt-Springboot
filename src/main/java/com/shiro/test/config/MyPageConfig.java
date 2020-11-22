package com.shiro.test.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author alvins
 * @Description Mybatis Plus分页插件配置
 * @date 2020/6/12 16:50
 * @since 1.0
 */
@Configuration
public class MyPageConfig {

    @Bean
    public PaginationInterceptor interceptor() {

        PaginationInterceptor interceptor =  new PaginationInterceptor();
        interceptor.setDbType(DbType.MYSQL);
        return interceptor;
    }
}
