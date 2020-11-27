package top.krasus1966.news.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author Krasus1966
 * @date 2020/10/26 17:58
 **/
@Configuration
@EnableOpenApi
public class Swagger3Config {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.OAS_30)
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("top.krasus1966.news.controller"))
                .paths(PathSelectors.any()).build()
                .apiInfo(new ApiInfoBuilder()
                        .title("SpringCloudNews")
                        .description("学习SpringCloud项目")
                        .version("0.0.1-SNAPSHOT")
                        .contact(new Contact("krasus1966",
                                "http://krasus1966.top",
                                "2134123985@qq.com"))
                        .termsOfServiceUrl("http://krasus1966.top")
                        .build());
    }
}
