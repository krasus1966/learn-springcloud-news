package top.krasus1966.news.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.news.controller.api.CommonControllerApi;
import top.krasus1966.news.entity.AppUser;
import top.krasus1966.news.result.Results;

/**
 * <p>
 * 网站用户 前端控制器
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@RestController
@RequestMapping("/news/app-user")
public class AppUserController implements CommonControllerApi<AppUser> {

    @Override
    public Results<AppUser> insert(AppUser appUser) {
        return null;
    }

    @Override
    public Results<AppUser> update(AppUser appUser) {
        return null;
    }

    @Override
    public Results<AppUser> delete(String ids) {
        return null;
    }

    @Override
    public Results<AppUser> query(AppUser appUser) {
        return null;
    }

    @Override
    public Results<AppUser> queryPage(Page<AppUser> page, AppUser appUser) {
        return null;
    }
}
