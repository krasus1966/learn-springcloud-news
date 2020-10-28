package top.krasus1966.news.user.service;

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
     * @param mobile
     * @return
     */
    AppUser queryMobileIsExist(String mobile);

    AppUser createUser(String mobile);
}
