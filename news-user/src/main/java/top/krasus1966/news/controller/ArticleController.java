package top.krasus1966.news.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.news.controller.api.CommonControllerApi;
import top.krasus1966.news.entity.Article;
import top.krasus1966.news.result.R;

/**
 * <p>
 * 文章资讯表 前端控制器
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@RestController
@RequestMapping("/news/article")
public class ArticleController implements CommonControllerApi<Article> {

    @Override
    public R<Article> insert(Article article) {
        return null;
    }

    @Override
    public R<Article> update(Article article) {
        return null;
    }

    @Override
    public R<Article> delete(String ids) {
        return null;
    }

    @Override
    public R<Article> query(Article article) {
        return null;
    }

    @Override
    public R<Article> queryPage(Page<Article> page, Article article) {
        return null;
    }
}
