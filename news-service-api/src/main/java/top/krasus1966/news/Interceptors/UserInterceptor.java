package top.krasus1966.news.Interceptors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.krasus1966.news.exception.CommonException;
import top.krasus1966.news.result.Constants;
import top.krasus1966.news.utils.TokenUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Krasus1966
 * @date 2020/10/28 17:14
 **/
@Slf4j
public class UserInterceptor extends BaseInterceptor implements HandlerInterceptor {

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
        String userToken = request.getHeader(Constants.USER_TOKEN);
        String userId = request.getHeader(Constants.USER_ID);
        try{
            return super.tokenUtils.verifyUserToken(userId,userToken,Constants.USER_TOKEN);
        }catch (CommonException e){
            log.error("CommonException:code={},msg={}", e.getResultEnum().getCode(), e.getResultEnum().getMsg());
            TokenUtils.setResponse(e,response);
            return false;
        }
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
