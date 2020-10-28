package top.krasus1966.news.controller.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import top.krasus1966.news.result.Results;

/**
 * @author Krasus1966
 * @date 2020/10/26 16:58
 **/
@Api(value = "controller的标题",tags = {"xx功能的Controller"})
public  interface CommonControllerApi<T> {

    @ApiOperation(value = "新增",notes = "新增",httpMethod = "POST")
    @PostMapping("/insert")
    Results<T> insert(T t);

    @ApiOperation(value = "修改",notes = "修改",httpMethod = "PUT")
    @PutMapping("/update")
    Results<T> update(T t);

    @ApiOperation(value = "删除",notes = "删除",httpMethod = "DELETE")
    @DeleteMapping("/delete")
    Results<T> delete(String ids);

    @ApiOperation(value = "查询",notes = "查询",httpMethod = "GET")
    @GetMapping("/query")
    Results<T> query(T t);

    @ApiOperation(value = "分页查询",notes = "分页查询",httpMethod = "GET")
    @GetMapping("/queryPage")
    Results<T> queryPage(Page<T> page,T t);
}
