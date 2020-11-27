package top.krasus1966.news.controller.api.sys;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import top.krasus1966.news.controller.api.CommonControllerApi;

/**
 * @author Krasus1966
 * @date 2020/11/27 00:05
 **/
@Api(value = "字典管理",tags = {"字典管理"})
@RequestMapping("/sys/dictionary")
public interface SysDictionaryApi extends CommonControllerApi {
}
