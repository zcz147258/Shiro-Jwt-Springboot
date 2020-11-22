package com.shiro.test.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @author alvins
 * @Description swagger接口文档生成配置
 * @date 2020/6/22 15:08
 * @since 1.0
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.shiro.test.controller"))
                .paths(PathSelectors.any())
                .build()
                .groupName("znq-service")
                .securityContexts(Lists.newArrayList(securityContext())).securitySchemes(Lists.newArrayList(apiKey()));
    }

    private ApiKey apiKey() {
        return new ApiKey("Bearer ", "token", "header");
    }

    /**
     * Swagger apiinfo
     * @return
     */
    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("周年庆活动接口文档")
                .description("api接口")
                .contact(new Contact("alvins", null, "qintian2xy@163.com"))
                .version("1.0")
                .build();
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/.*"))
                .build();
    }

    private List<SecurityReference> defaultAuth() {

        AuthorizationScope scope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] scopes = new AuthorizationScope[1];
        scopes[0] = scope;
        return Lists.newArrayList(new SecurityReference("Bearer ", scopes));
    }
}
