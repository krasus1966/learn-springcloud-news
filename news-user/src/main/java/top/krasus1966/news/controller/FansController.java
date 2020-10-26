package top.krasus1966.news.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.news.controller.CommonControllerApi;
import top.krasus1966.news.entity.Fans;
import top.krasus1966.news.result.Results;

/**
 * <p>
 * 粉丝表，用户与粉丝的关联关系，粉丝本质也是用户。
关联关系保存到es中，粉丝数方式和用户点赞收藏文章一样。累加累减都用redis来做。
字段与用户表有些冗余，主要用于数据可视化，数据一旦有了之后，用户修改性别和省份无法影响此表，只认第一次的数据。

 前端控制器
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@RestController
@RequestMapping("/news/fans")
public class FansController implements CommonControllerApi<Fans> {

    @Override
    public Results<Fans> insert(Fans fans) {
        return null;
    }

    @Override
    public Results<Fans> update(Fans fans) {
        return null;
    }

    @Override
    public Results<Fans> delete(String ids) {
        return null;
    }

    @Override
    public Results<Fans> query(Fans fans) {
        return null;
    }

    @Override
    public Results<Fans> queryPage(Page<Fans> page, Fans fans) {
        return null;
    }
}
