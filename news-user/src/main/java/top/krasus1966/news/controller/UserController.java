package top.krasus1966.news.controller;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.news.bo.UpdateUserInfoBO;
import top.krasus1966.news.controller.api.UserInfoControllerApi;
import top.krasus1966.news.entity.AppUser;
import top.krasus1966.news.enums.ResultEnum;
import top.krasus1966.news.result.BindingResultError;
import top.krasus1966.news.result.Results;
import top.krasus1966.news.service.IAppUserService;
import top.krasus1966.news.vo.AppUserVO;

import javax.validation.Valid;
import java.util.Map;

/**
 * @author Krasus1966
 * @date 2020/10/31 23:24
 **/
@RestController
public class UserController extends BaseController implements UserInfoControllerApi {

    @Autowired
    private IAppUserService userService;

    @Override
    public Results<AppUserVO> getUserInfo(String userId) {
        if (StrUtil.hasBlank(userId)){
            return Results.parse(ResultEnum.UN_LOGIN);
        }
        AppUser appUser = userService.getById(userId);
        AppUserVO userAccountInfo = new AppUserVO();
        BeanUtils.copyProperties(appUser,userAccountInfo);
        return Results.parse(ResultEnum.SUCCESS,userAccountInfo);
    }

    @Override
    public Results<UpdateUserInfoBO> updateUserInfo(@Valid UpdateUserInfoBO updateUserInfoBO, BindingResult result) {
        if (result.hasErrors()){
            Map<String,String> map = BindingResultError.getError(result);
            return Results.parse(ResultEnum.PARAM_NOT_VALID,map);
        }
        AppUser appUser = userService.getById(updateUserInfoBO.getId());
        BeanUtils.copyProperties(updateUserInfoBO,appUser);
        if (userService.updateById(appUser)){
            return Results.parse(ResultEnum.SUCCESS,updateUserInfoBO);
        }else{
            return Results.parse(ResultEnum.FAILED);
        }
    }
}
