package top.krasus1966.news.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.news.controller.api.CommonControllerApi;
import top.krasus1966.news.entity.Category;
import top.krasus1966.news.result.R;


/**
 * <p>
 * 新闻资讯文章的分类（或者称之为领域） 前端控制器
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@RestController
@RequestMapping("/news/category")
public class CategoryController implements CommonControllerApi<Category> {

    @Override
    public R<Category> insert(Category category) {
        return null;
    }

    @Override
    public R<Category> update(Category category) {
        return null;
    }

    @Override
    public R<Category> delete(String ids) {
        return null;
    }

    @Override
    public R<Category> query(Category category) {
        return null;
    }

    @Override
    public R<Category> queryPage(Page<Category> page, Category category) {
        return null;
    }
}
