package top.krasus1966.news.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.krasus1966.news.result.R;
import top.krasus1966.news.enums.ResultsEnum;
import top.krasus1966.news.exception.CommonException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author Krasus1966
 * @date 2020/10/29 22:44
 **/
@Component
public class TokenUtils {

    @Autowired
    private RedisUtils redisUtils;

    private TokenUtils() {
    }

    //将Token存到cookie中
    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String cookieValue, Integer maxAge) {
        try {
            cookieValue = URLEncoder.encode(cookieValue, "utf-8");
            Cookie cookie = new Cookie(cookieName, cookieValue);
            cookie.setMaxAge(maxAge);
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public static void setHeader(HttpServletRequest request, HttpServletResponse response, String headerName, String token, Integer maxAge) {
        try {
            response.setHeader(headerName, token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean verifyUserToken(String id, String token, String redisKeyPrefix) {
        if (StrUtil.isNotBlank(id) && StrUtil.isNotBlank(token)) {
            String redisToken = redisUtils.get(redisKeyPrefix + ":" + id);
            if (StrUtil.isBlank(redisToken)) {
                R.error(ResultsEnum.SESSION_INVALID);
                return false;
            } else {
                if (!redisToken.equals(token)) {
                    R.error(ResultsEnum.UN_LOGIN);
                    return false;
                }
                return true;
            }
        } else {
            R.error(ResultsEnum.UN_LOGIN);
            return false;
        }
    }

    public static void setResponse(CommonException e, HttpServletResponse response) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.print(JSONUtil.parse(e.getResultEnum()));
        pw.close();
        response.flushBuffer();
    }
}
