package top.krasus1966.news.service.impl;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.krasus1966.news.mapper.AppUserMapper;
import top.krasus1966.news.service.IAppUserService;
import top.krasus1966.news.entity.AppUser;
import top.krasus1966.news.enums.dict.SexEnum;
import top.krasus1966.news.enums.dict.StatusEnum;
import top.krasus1966.news.result.Constants;
import top.krasus1966.news.utils.JsonUtils;
import top.krasus1966.news.utils.RedisUtils;

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
@Slf4j
public class AppUserServiceImpl extends ServiceImpl<AppUserMapper, AppUser> implements IAppUserService {

    @Autowired
    private RedisUtils redisUtils;

    @Override
    public AppUser queryMobileIsExist(String mobile) {
        QueryWrapper<AppUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile", mobile);
        return super.getOne(queryWrapper);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public AppUser createUser(String mobile) {
        AppUser user = new AppUser();
        user.setId(UUID.fastUUID().toString().substring(0, 20));
        user.setMobile(mobile);
        user.setNickname("用户：" + mobile);
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

    @Override
    public boolean updateUserInfo(AppUser appUser) {

        // 更新前删除缓存
        String userId = appUser.getId();
        redisUtils.del(Constants.USER_INFO + ":" + userId);
        boolean result = super.updateById(appUser);
        if (result) {
            AppUser userInfo = this.getUserById(userId);
            // 重写缓存数据
            redisUtils.set(Constants.USER_INFO + ":" + userId, JsonUtils.objectToJson(userInfo));
        }
        try {
            // 等待后再次删除缓存
            Thread.sleep(100);
            redisUtils.del(Constants.USER_INFO + ":" + userId);
            return result;
        } catch (InterruptedException e) {
            log.error("catch InterruptedException",e);
            Thread.currentThread().interrupt();
        }
        return result;
    }

    @Override
    public AppUser getUserById(String userId) {
        AppUser user = null;
        String userJson = redisUtils.get(Constants.USER_INFO + ":" + userId);
        if (!StrUtil.isNotBlank(userJson)) {
            user = JsonUtils.jsonToPojo(userJson, AppUser.class);
        } else {
            user = super.getById(userId);
            redisUtils.set(Constants.USER_INFO + ":" + userId, JsonUtils.objectToJson(user));
        }
        return user;
    }
}
