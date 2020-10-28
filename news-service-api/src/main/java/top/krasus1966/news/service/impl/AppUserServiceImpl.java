package top.krasus1966.news.service.impl;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;
import top.krasus1966.news.entity.AppUser;
import top.krasus1966.news.enums.dict.SexEnum;
import top.krasus1966.news.enums.dict.StatusEnum;
import top.krasus1966.news.mapper.AppUserMapper;
import top.krasus1966.news.user.service.IAppUserService;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
 * <p>
 * 网站用户 服务实现类
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@Service
public class AppUserServiceImpl extends ServiceImpl<AppUserMapper, AppUser> implements IAppUserService {

    @Override
    public AppUser queryMobileIsExist(String mobile) {
        QueryWrapper<AppUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile",mobile);
        return super.getOne(queryWrapper);
    }

    @Transient
    @Override
    public AppUser createUser(String mobile) {
        AppUser user = new AppUser();
        user.setId(UUID.fastUUID().toString().substring(0,20));
        user.setMobile(mobile);
        user.setNickname("用户："+mobile);
        user.setFace("");
        user.setBirthday(LocalDate.parse("1900-01-01", DateTimeFormatter.ISO_DATE));
        user.setSex(SexEnum.SECRET.type);
        user.setActiveStatus(StatusEnum.STATUS_ON.type);
        user.setTotalIncome(0);
        user.setCreatedTime(LocalDateTime.now());
        user.setUpdatedTime(LocalDateTime.now());
        super.save(user);
        return user;
    }
}
