package top.krasus1966.news.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.krasus1966.news.mapper.AdminUserMapper;
import top.krasus1966.news.service.IAdminUserService;
import top.krasus1966.news.entity.AdminUser;

/**
 * <p>
 * 运营管理平台的admin级别用户 服务实现类
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements IAdminUserService {

}
