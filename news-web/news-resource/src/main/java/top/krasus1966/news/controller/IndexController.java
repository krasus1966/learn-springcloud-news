package top.krasus1966.news.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.krasus1966.news.enums.ResultsEnum;
import top.krasus1966.news.result.R;

/**
 * @author Krasus1966
 * @date 2020/11/15 15:12
 **/
@RestController
@RequestMapping("/resource")
public class IndexController {

    /**
     * 验证服务启动
     * @return 返回值
     */
    @RequestMapping("/index")
    public R index(){
        return R.parse(ResultsEnum.SUCCESS);
    }
}
