package top.krasus1966.news.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.krasus1966.news.enums.ResultsEnum;
import top.krasus1966.news.result.StaticUtils;
import top.krasus1966.news.result.R;
import top.krasus1966.news.utils.IPUtils;
import top.krasus1966.news.utils.RedisUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Krasus1966
 * @date 2020/10/28 17:14
 **/
public class PassportInterceptor implements HandlerInterceptor {

    @Autowired
    public RedisUtils redisUtils;
    /**
     * 拦截请求 false拦截 true放行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userIp = IPUtils.getRequestIp(request);
        boolean keyIsExist = redisUtils.keyIsExist(StaticUtils.MOBILE_SMSCODE+":"+userIp);
        if (keyIsExist){
            R.error(ResultsEnum.PASSPORT_TOO_BUSY);
            return false;
        }
        return true;
    }

    /**
     * 请求后，渲染视图前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 请求后，渲染视图后
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
