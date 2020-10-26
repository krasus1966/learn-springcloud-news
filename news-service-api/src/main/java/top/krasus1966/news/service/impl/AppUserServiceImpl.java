package top.krasus1966.news.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.krasus1966.news.entity.AppUser;
import top.krasus1966.news.mapper.AppUserMapper;
import top.krasus1966.news.user.service.IAppUserService;


/**
 * <p>
 * 网站用户 服务实现类
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@Service
public class AppUserServiceImpl extends ServiceImpl<AppUserMapper, AppUser> implements IAppUserService {

}
