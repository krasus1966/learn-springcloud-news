package top.krasus1966.news.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import top.krasus1966.news.result.Results;

/**
 * @author Krasus1966
 * @date 2020/10/26 23:49
 **/
@Api(value = "用户注册登陆",tags = {"用户注册登陆的controller"})
public interface PassportControllerApi {

    @ApiOperation(value = "获得短信验证码",notes = "获得短信验证码",httpMethod = "POST")
    @PostMapping("/getSMSCode")
    Results getSMSCode();

}
