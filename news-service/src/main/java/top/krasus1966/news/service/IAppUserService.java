package top.krasus1966.news.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.krasus1966.news.entity.AppUser;

/**
 * <p>
 * 网站用户 服务类
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
public interface IAppUserService extends IService<AppUser> {

    /**
     * 查询用户是否存在
     *
     * @param mobile 手机号码
     * @return @{appUser}
     */
    AppUser queryMobileIsExist(String mobile);

    /**
     * 创建用户
     * @param mobile 手机号码
     * @return @{appUser}
     */
    AppUser createUser(String mobile);

    /**
     * 更新用户信息并保存至redis
     * @param appUser 用户
     * @return @{true:false}
     */
    boolean updateUserInfo(AppUser appUser);

    /**
     * 通过id获取用户信息并保存至redis
     * @param userId 用户id
     * @return @{appUser}
     */
    AppUser getUserById(String userId);

}
