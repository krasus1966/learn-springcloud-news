package top.krasus1966.news.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.krasus1966.news.entity.Category;
import top.krasus1966.news.mapper.CategoryMapper;
import top.krasus1966.news.service.ICategoryService;


/**
 * <p>
 * 新闻资讯文章的分类（或者称之为领域） 服务实现类
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
