package com.example.conf;

import com.example.anno.MyAnnotationSwagger;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static com.google.common.base.Predicates.not;
import static springfox.documentation.builders.RequestHandlerSelectors.withMethodAnnotation;

/**
 * created by dfk
 * 2022/4/23
 */
@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket docket() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
        //帮助文档的描述信息
        ApiInfo apiInfo = new ApiInfoBuilder()

                .contact(new Contact(
                        "lucia",//文档发布者名称
                        "http://www.baidu.com",//文档发布者网址
                        "12345@qq.com"))//文档发布者邮箱
                .title("开发文档")//文档标题
                .description("开发文档详细描述-swagger简单使用")
                .version("1.1")
                .build();
        docket.apiInfo(apiInfo);

        docket = docket
                .select()//获取Docket中的选择器，返回ApiSelector，构建选择器，如扫描哪个包
                .apis(not(
                        //方法上有MyAnnotationSwagger注解，帮助文档显示该方法
                        withMethodAnnotation(MyAnnotationSwagger.class)
                ))
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .paths(
                        PathSelectors.regex("/api/.*"))//api，才能生成文档
                .build();//扫描哪个包中的注解
        return docket;
    }
}
