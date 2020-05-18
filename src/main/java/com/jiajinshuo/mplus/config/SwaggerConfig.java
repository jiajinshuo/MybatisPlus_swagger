package com.jiajinshuo.mplus.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author jiajinshuo
 * @create 2020-05-18 13:58
 */
@Configuration
@EnableSwagger2 // 开启Swagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }

    // 配置swagger的docket的bean实例
    @Bean
    public Docket docket(Environment environment){
        // 设置要显示的swagger环境
        Profiles profile = Profiles.of("dev");
        boolean flag = environment.acceptsProfiles(profile);

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("jiajinshuo")
                .apiInfo(apiInfo())
                .enable(true)
                .select()
                // 指定要扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.jiajinshuo.mplus.controller"))
                // 过滤路径
//                .paths(PathSelectors.ant("/"))
                .build();

    }
    // 配置api info
    private ApiInfo apiInfo(){
        Contact contact = new Contact("贾谨硕", "http://www.baidu.com", "qqq.com");
        // 作者信息
        return new ApiInfo(
                "jiajinshuo",
                "这里是描述",
                "1.0",
                "http://www.baidu.com",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()

        );
    }

}
