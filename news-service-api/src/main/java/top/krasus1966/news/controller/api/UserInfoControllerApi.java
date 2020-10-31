package top.krasus1966.news.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.krasus1966.news.bo.UpdateUserInfoBO;
import top.krasus1966.news.result.Results;
import top.krasus1966.news.vo.AppUserVO;

import javax.validation.Valid;

/**
 * @author Krasus1966
 * @date 2020/10/31 23:22
 **/
@Api(value = "用户信息", tags = {"用户信息"})
@RequestMapping("/userInfo")
public interface UserInfoControllerApi {

    @ApiOperation(value = "获得账户信息", notes = "获得账户信息", httpMethod = "POST")
    @PostMapping("/getUserInfo")
    Results<AppUserVO> getUserInfo(@RequestParam String userId);

    @ApiOperation(value = "修改账户信息", notes = "修改账户信息", httpMethod = "POST")
    @PostMapping("/updateUserInfo")
    Results<UpdateUserInfoBO> updateUserInfo(UpdateUserInfoBO updateUserInfoBO, BindingResult result);
}
