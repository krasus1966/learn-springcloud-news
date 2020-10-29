package top.krasus1966.news.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author Krasus1966
 * @date 2020/10/29 22:44
 **/
public class TokenUtils {

    private TokenUtils(){}

    //将Token存到cookie中
    public static void setCookie(HttpServletRequest request, HttpServletResponse response,String cookieName,String cookieValue,Integer maxAge){
        try {
            cookieValue = URLEncoder.encode(cookieValue,"utf-8");
            Cookie cookie = new Cookie(cookieName,cookieValue);
            cookie.setMaxAge(maxAge);
            // 设置域名
            //cookie.setDomain();
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
