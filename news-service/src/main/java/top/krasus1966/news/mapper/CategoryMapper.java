package top.krasus1966.news.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.krasus1966.news.entity.Category;

/**
 * <p>
 * 新闻资讯文章的分类（或者称之为领域） Mapper 接口
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@Mapper
public interface CategoryMapper extends BaseMapper<Category> {

}
