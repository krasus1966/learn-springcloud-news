package top.krasus1966.news.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.krasus1966.news.bo.RegistLoginBO;
import top.krasus1966.news.enums.IResultEnum;
import top.krasus1966.news.result.Results;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Krasus1966
 * @date 2020/10/26 23:49
 **/
@Api(value = "用户注册登陆",tags = {"用户注册登陆的controller"})
@RequestMapping("passport")
public interface PassportControllerApi {

    @ApiOperation(value = "获得短信验证码",notes = "获得短信验证码",httpMethod = "POST")
    @PostMapping("/getSMSCode")
    Results<String> getSMSCode(String mobile, HttpServletRequest request);

    @ApiOperation(value = "一键登录注册",notes = "一键登录注册",httpMethod = "POST")
    @PostMapping("/doLogin")
    Results<Integer> doLogin(RegistLoginBO registLoginBO, BindingResult result,HttpServletRequest request, HttpServletResponse response);
}
