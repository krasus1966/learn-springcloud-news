package top.krasus1966.news.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.spring.SpringUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.krasus1966.news.result.Constants;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Krasus1966
 * @date 2020/11/6 15:56
 **/
public class LoginUtils {

    public static String getToken(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request.getHeader(Constants.USER_TOKEN);
    }

    public static Cookie getCookie(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:cookies){
            if (StrUtil.isNotBlank(cookie.getName())&& cookie.getName().equals(Constants.USER_ID)){
                return cookie;
            }
        }
        return null;
    }

    public static boolean logout(){
        String token = getToken();
        RedisUtils redisUtils = SpringUtil.getBean(RedisUtils.class);
        if(StrUtil.isNotBlank(token)){
            redisUtils.del(Constants.USER_TOKEN+":"+token);
            return true;
        }
        return false;
    }
}
