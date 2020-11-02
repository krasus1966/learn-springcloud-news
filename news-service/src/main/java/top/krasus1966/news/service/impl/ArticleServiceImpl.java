package top.krasus1966.news.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.krasus1966.news.entity.Article;
import top.krasus1966.news.mapper.ArticleMapper;
import top.krasus1966.news.service.IArticleService;

/**
 * <p>
 * 文章资讯表 服务实现类
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
