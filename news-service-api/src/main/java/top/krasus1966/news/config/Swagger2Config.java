package top.krasus1966.news.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.function.Predicate;

/**
 * @author Krasus1966
 * @date 2020/10/26 17:58
 **/
@Configuration
@EnableOpenApi
public class Swagger2Config {
    public Docket createRestApi(){
        Predicate<RequestHandler> adminPredicate = RequestHandlerSelectors.basePackage("top.krasus1966.admin.controller");
        Predicate<RequestHandler> articlePredicate = RequestHandlerSelectors.basePackage("top.krasus1966.article.controller");
        Predicate<RequestHandler> userPredicate = RequestHandlerSelectors.basePackage("top.krasus1966.user.controller");
        Predicate<RequestHandler> filesPredicate = RequestHandlerSelectors.basePackage("top.krasus1966.files.controller");
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(adminPredicate.or(articlePredicate).or(userPredicate).or(filesPredicate))
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("SpringCloudNews")
                .contact(new Contact("krasus1966",
                        "http://krasus1966.top",
                        "2134123985@qq.com"))
                .description("学习SpringCloud项目")
                .version("0.0.1-SNAPSHOT")
                .termsOfServiceUrl("http://krasus1966.top")
                .build();

    }
}
