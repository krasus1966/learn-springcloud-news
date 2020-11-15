package top.krasus1966.news.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import top.krasus1966.news.utils.RedisUtils;
import top.krasus1966.news.utils.TokenUtils;

/**
 * @author Krasus1966
 * @date 2020/11/2 22:58
 **/
public class BaseInterceptor {
    @Autowired
    public RedisUtils redisUtils;

    @Autowired
    public TokenUtils tokenUtils;

//    public boolean verifyUserToken(String id,String token,String redisKeyPrefix){
//        if (StrUtil.isNotBlank(id) && StrUtil.isNotBlank(token)){
//            String redisToken = redisUtils.get(redisKeyPrefix+":"+id);
//            if (StrUtil.isBlank(redisToken)){
//                R.error(ResultsEnum.UN_LOGIN);
//                return false;
//            }else {
//                if (!redisToken.equals(token)){
//                    R.error(ResultsEnum.UN_LOGIN);
//                    return false;
//                }
//                return true;
//            }
//        }else{
//            R.error(ResultsEnum.UN_LOGIN);
//            return false;
//        }
//    }
}
