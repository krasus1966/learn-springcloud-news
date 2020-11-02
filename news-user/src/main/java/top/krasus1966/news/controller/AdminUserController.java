package top.krasus1966.news.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.news.controller.api.CommonControllerApi;
import top.krasus1966.news.entity.AdminUser;
import top.krasus1966.news.result.R;

/**
 * <p>
 * 运营管理平台的admin级别用户 前端控制器
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@RestController
@RequestMapping("/news/admin-user")
public class AdminUserController implements CommonControllerApi<AdminUser> {

    @Override
    public R<AdminUser> insert(AdminUser adminUser) {
        return null;
    }

    @Override
    public R<AdminUser> update(AdminUser adminUser) {
        return null;
    }

    @Override
    public R<AdminUser> delete(String ids) {
        return null;
    }

    @Override
    public R<AdminUser> query(AdminUser adminUser) {
        return null;
    }

    @Override
    public R<AdminUser> queryPage(Page<AdminUser> page, AdminUser adminUser) {
        return null;
    }
}
