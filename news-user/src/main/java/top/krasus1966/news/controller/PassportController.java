package top.krasus1966.news.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.news.controller.PassportControllerApi;
import top.krasus1966.news.result.ResultEnum;
import top.krasus1966.news.result.Results;
import top.krasus1966.news.utils.SmsUtils;

/**
 * @author Krasus1966
 * @date 2020/10/26 23:53
 **/
@RestController
public class PassportController implements PassportControllerApi {

    @Autowired
    private SmsUtils smsUtils;

    @Override
    public Results getSMSCode() {
        String random = "1234";
        smsUtils.sendSms("18847020981",random);
        return Results.parse(ResultEnum.SUCCESS);
    }
}
