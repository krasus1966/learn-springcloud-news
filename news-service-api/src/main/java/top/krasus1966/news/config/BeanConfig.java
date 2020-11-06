package top.krasus1966.news.config;

import cn.hutool.extra.spring.SpringUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Krasus1966
 * @date 2020/11/6 17:03
 **/
@Configuration
@Import(SpringUtil.class)
public class BeanConfig {

//    @Bean
//    public RedisUtils redisUtils(){
//        return new RedisUtils();
//    }
}
