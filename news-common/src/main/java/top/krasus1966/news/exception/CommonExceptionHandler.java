package top.krasus1966.news.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.krasus1966.news.result.Results;

/**
 * @author Krasus1966
 * @date 2020/10/28 18:03
 **/
@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    @ExceptionHandler(value = CommonException.class)
    public Results<String> errorHandler(CommonException e) {
        log.error("CommonException:code={},msg={}", e.getErrorEnum().getCode(),e.getErrorEnum().getMsg());
        return Results.parse(e.getErrorEnum());
    }
}
