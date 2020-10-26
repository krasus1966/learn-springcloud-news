package top.krasus1966.news.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.krasus1966.news.entity.AdminUser;

/**
 * <p>
 * 运营管理平台的admin级别用户 Mapper 接口
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@Mapper
public interface AdminUserMapper extends BaseMapper<AdminUser> {

}
