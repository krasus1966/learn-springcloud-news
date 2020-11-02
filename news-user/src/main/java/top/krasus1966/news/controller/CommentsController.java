package top.krasus1966.news.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.news.controller.api.CommonControllerApi;
import top.krasus1966.news.entity.Comments;
import top.krasus1966.news.result.R;

/**
 * <p>
 * 文章评论表 前端控制器
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@RestController
@RequestMapping("/news/comments")
public class CommentsController implements CommonControllerApi<Comments> {

    @Override
    public R<Comments> insert(Comments comments) {
        return null;
    }

    @Override
    public R<Comments> update(Comments comments) {
        return null;
    }

    @Override
    public R<Comments> delete(String ids) {
        return null;
    }

    @Override
    public R<Comments> query(Comments comments) {
        return null;
    }

    @Override
    public R<Comments> queryPage(Page<Comments> page, Comments comments) {
        return null;
    }
}
