package com.feng.springboot.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
    //http://localhost:8088/swagger-ui.html     原路径
    //http://localhost:8088/doc.html            原路径
    //配置Swagger2核心配置
    @Bean
    public Docket createRestApi(){

        return new Docket(DocumentationType.SWAGGER_2)   //指定api类型Swagger_2
                .apiInfo(apiInfo())                      //用于定义API文档汇总信息
                .select()
                .apis(RequestHandlerSelectors
                .basePackage("com.feng.springboot.controller")) //扫描controller包
                .paths(PathSelectors.any())                 //所有controller
                .build();
     }
     private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("天天吃货平台接口API")                              //文档标题
                .contact(new Contact("fengfeng" ,
                        "fengfeng1.com",
                        "123@qq.com"))                           //联系人信息
                .description("专为天天吃货提供的API文档")
                .version("1.0.1")                                       //文档版本号
                .termsOfServiceUrl("fengfeng1.com")
                .build();


     }
}
