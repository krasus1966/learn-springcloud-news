package top.krasus1966.news.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.news.bo.RegistLoginBO;
import top.krasus1966.news.controller.api.PassportControllerApi;
import top.krasus1966.news.entity.AppUser;
import top.krasus1966.news.enums.ResultsEnum;
import top.krasus1966.news.enums.dict.StatusEnum;
import top.krasus1966.news.result.BindingResultError;
import top.krasus1966.news.result.StaticUtils;
import top.krasus1966.news.result.R;
import top.krasus1966.news.service.IAppUserService;
import top.krasus1966.news.utils.IPUtils;
import top.krasus1966.news.utils.LoginUtils;
import top.krasus1966.news.utils.SmsUtils;
import top.krasus1966.news.utils.TokenUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

/**
 * @author Krasus1966
 * @date 2020/10/26 23:53
 **/
@RestController
public class PassportController extends BaseController implements PassportControllerApi {

    @Autowired
    private SmsUtils smsUtils;

    @Autowired
    private IAppUserService appUserService;

    @Override
    public R<String> getSMSCode(@RequestParam String mobile, HttpServletRequest request) {
        //获得用户ip地址
        String userIp = IPUtils.getRequestIp(request);
        //根据用户ip限制用户60秒才能请求一次短信
        redisUtils.setnx60s(StaticUtils.MOBILE_SMSCODE+":"+userIp,userIp);
        //生成随机验证码
        String random = (int)((Math.random() *9 +1) * 100000) + "";
        //发送短信
//        smsUtils.sendSms(mobile,random);
        //验证码存入redis，用于后续验证
        redisUtils.set(StaticUtils.MOBILE_SMSCODE+":"+mobile,random,30 * 60);

        return R.parse(ResultsEnum.SUCCESS,random);
    }

    @Override
    public R<Integer> doLogin(@Valid RegistLoginBO registLoginBO, BindingResult result, HttpServletRequest request, HttpServletResponse response) {
        if (result.hasErrors()){
            Map<String,String> map = BindingResultError.getError(result);
            return R.parse(ResultsEnum.PARAM_NOT_VALID,map);
        }
        // 验证验证码是否匹配
        String mobile = registLoginBO.getMobile();
        String smsCode = registLoginBO.getSmsCode();
        String redisCode = redisUtils.get(StaticUtils.MOBILE_SMSCODE+":"+mobile);
        if (!StrUtil.isNotBlank(redisCode)){
            return R.parse(ResultsEnum.SMS_CODE_TIME_OUT);
        }
        if (!redisCode.equalsIgnoreCase(smsCode)){
            return R.parse(ResultsEnum.SMS_CODE_ERROR);
        }
        // 通过手机号获取数据库中的用户
        AppUser user = appUserService.getOne(new QueryWrapper<AppUser>().eq("mobile",mobile));
        if (user != null && StatusEnum.STATUS_OFF.type.equals(user.getActiveStatus())){
            return R.parse(ResultsEnum.USER_FROZEN);
        }else if (null == user){
            user = appUserService.createUser(mobile);
        }

        int userActiveStatus = user.getActiveStatus();
        if (userActiveStatus != StatusEnum.STATUS_OFF.type){
            // 保存token
            String token = UUID.randomUUID().toString();
            redisUtils.set(StaticUtils.USER_TOKEN+":"+user.getId(),token);

            // 保存用户ID和token到cookie中
            TokenUtils.setHeader(request,response, StaticUtils.USER_TOKEN,token, StaticUtils.COOKIE_TIME_OUT_MONTH);
            TokenUtils.setCookie(request,response, StaticUtils.USER_ID,user.getId(), StaticUtils.COOKIE_TIME_OUT_MONTH);
        }

        redisUtils.del(StaticUtils.MOBILE_SMSCODE+":"+mobile);
        return R.parse(ResultsEnum.SUCCESS,userActiveStatus);
    }

    @Override
    public R logout(HttpServletRequest request, HttpServletResponse response) {
        if (LoginUtils.logout()){
            return R.parse(ResultsEnum.LOG_OUT_SUCCESS);
        }
        return R.parse(ResultsEnum.LOG_OUT_FAIL);
    }
}
