package top.krasus1966.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.news.controller.api.PassportControllerApi;
import top.krasus1966.news.enums.ResultEnum;
import top.krasus1966.news.result.Results;
import top.krasus1966.news.result.StaticConstant;
import top.krasus1966.news.utils.IPUtils;
import top.krasus1966.news.utils.SmsUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Krasus1966
 * @date 2020/10/26 23:53
 **/
@RestController
public class PassportController extends BaseController implements PassportControllerApi {

    @Autowired
    private SmsUtils smsUtils;

    @Override
    public Results getSMSCode(String mobile, HttpServletRequest request) {
        //获得用户ip地址
        String userIp = IPUtils.getRequestIp(request);
        //根据用户ip限制用户60秒才能请求一次短信
        redisUtils.setnx60s(StaticConstant.MOBILE_SMSCODE+":"+userIp,userIp);
        //生成随机验证码
        String random = (int)((Math.random() *9 +1) * 100000) + "";
        //发送短信
//        smsUtils.sendSms(mobile,random);
        //验证码存入redis，用于后续验证
        redisUtils.set(StaticConstant.MOBILE_SMSCODE+":"+mobile,random,30 * 60);

        return Results.parse(ResultEnum.SUCCESS);
    }

    @GetMapping("/redis")
    public Results redis(){
        redisUtils.set("age","18");
        return Results.parse(ResultEnum.SUCCESS,redisUtils.get("age"));
    }
}
