package top.krasus1966.news.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import top.krasus1966.news.bo.UpdateUserInfoBO;
import top.krasus1966.news.result.R;
import top.krasus1966.news.vo.AppUserVO;
import top.krasus1966.news.vo.UserAccountVO;


/**
 * @author Krasus1966
 * @date 2020/10/31 23:22
 **/
@Api(value = "用户信息", tags = {"用户信息"})
@RequestMapping("/userInfo")
public interface UserInfoControllerApi {

    /**
     * 获得账户信息
     * @param userId
     * @return
     */
    @ApiOperation(value = "获得账户信息", notes = "获得账户信息", httpMethod = "POST")
    @PostMapping("/getAccountInfo")
    R<UserAccountVO> getAccountInfo(String userId);

    /**
     * 获得用户基本信息
     * @param userId
     * @return
     */
    @ApiOperation(value = "获得用户基本信息", notes = "获得用户基本信息", httpMethod = "GET")
    @GetMapping("/getUserInfo")
    R<AppUserVO> getUserInfo(String userId);

    /**
     * 修改账户信息
     * @param updateUserInfoBO
     * @param result
     * @return
     */
    @ApiOperation(value = "修改账户信息", notes = "修改账户信息", httpMethod = "POST")
    @PostMapping("/updateUserInfo")
    R<UpdateUserInfoBO> updateUserInfo(UpdateUserInfoBO updateUserInfoBO, BindingResult result);
}
