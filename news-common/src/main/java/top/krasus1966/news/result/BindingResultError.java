package top.krasus1966.news.result;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取BindingResult中数据验证错误信息
 *
 * @author Krasus1966
 * @date 2020/10/28 21:54
 **/
public class BindingResultError {
    public static Map<String, String> getError(BindingResult result){
        Map<String,String> map = new HashMap<>();
        List<FieldError> errorList = result.getFieldErrors();
        for (FieldError error : errorList){
            map.put(error.getField(),error.getDefaultMessage());
        }
        return map;
    }
}
