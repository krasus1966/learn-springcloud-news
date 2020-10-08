package top.krasus1966.news.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.news.api.controller.user.HelloControllerApi;
import top.krasus1966.news.result.Results;

/**
 * @author Krasus1966
 * @date 2020/10/7 23:39
 **/
@RestController
public class HelloController implements HelloControllerApi {

    final static Logger logger = LoggerFactory.getLogger(HelloController.class);

    @Override
    public String hello(){

        return "hello world";
    }
}
