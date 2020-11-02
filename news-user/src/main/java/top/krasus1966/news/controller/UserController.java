package top.krasus1966.news.controller;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.news.bo.UpdateUserInfoBO;
import top.krasus1966.news.controller.api.UserInfoControllerApi;
import top.krasus1966.news.entity.AppUser;
import top.krasus1966.news.enums.ResultsEnum;
import top.krasus1966.news.enums.dict.StatusEnum;
import top.krasus1966.news.result.BindingResultError;
import top.krasus1966.news.result.R;
import top.krasus1966.news.service.IAppUserService;
import top.krasus1966.news.vo.AppUserVO;
import top.krasus1966.news.vo.UserAccountVO;

import javax.validation.Valid;
import java.time.LocalDateTime;
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
    public R<UserAccountVO> getAccountInfo(String userId) {
        if (StrUtil.hasBlank(userId)){
            return R.parse(ResultsEnum.UN_LOGIN);
        }
        AppUser appUser = userService.getById(userId);
        UserAccountVO userAccountInfo = new UserAccountVO();
        BeanUtils.copyProperties(appUser,userAccountInfo);
        return R.parse(ResultsEnum.SUCCESS,userAccountInfo);
    }

    @Override
    public R<AppUserVO> getUserInfo(String userId) {
        if (StrUtil.hasBlank(userId)){
            return R.parse(ResultsEnum.UN_LOGIN);
        }
        AppUser appUser = userService.getById(userId);
        AppUserVO userVO = new AppUserVO();
        BeanUtils.copyProperties(appUser,userVO);
        return R.parse(ResultsEnum.SUCCESS,userVO);
    }

    @Override
    public R<UpdateUserInfoBO> updateUserInfo(@Valid UpdateUserInfoBO updateUserInfoBO, BindingResult result) {
        if (result.hasErrors()){
            Map<String,String> map = BindingResultError.getError(result);
            return R.parse(ResultsEnum.PARAM_NOT_VALID,map);
        }
        AppUser appUser = userService.getById(updateUserInfoBO.getId());
        BeanUtils.copyProperties(updateUserInfoBO,appUser);
        appUser.setUpdatedTime(LocalDateTime.now());
        appUser.setActiveStatus(StatusEnum.STATUS_ON.type);
        if (userService.updateById(appUser)){
            return R.parse(ResultsEnum.SUCCESS,updateUserInfoBO);
        }else{
            return R.parse(ResultsEnum.FAILED);
        }
    }
}
