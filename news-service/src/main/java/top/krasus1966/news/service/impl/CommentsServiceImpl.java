package top.krasus1966.news.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.krasus1966.news.mapper.CommentsMapper;
import top.krasus1966.news.service.ICommentsService;
import top.krasus1966.news.entity.Comments;


/**
 * <p>
 * 文章评论表 服务实现类
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@Service
public class CommentsServiceImpl extends ServiceImpl<CommentsMapper, Comments> implements ICommentsService {

}
