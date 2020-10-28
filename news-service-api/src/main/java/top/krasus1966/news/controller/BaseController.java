package top.krasus1966.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import top.krasus1966.news.utils.RedisUtils;

/**
 * @author Krasus1966
 * @date 2020/10/28 16:39
 **/
public class BaseController {
    @Autowired
    public RedisUtils redisUtils;



}
