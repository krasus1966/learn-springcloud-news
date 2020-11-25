package top.krasus1966.news.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.krasus1966.news.enums.ResultsEnum;
import top.krasus1966.news.result.R;

/**
 * 通用自定义异常处理
 *
 * @author Krasus1966
 * @date 2020/10/28 18:03
 **/
@RestControllerAdvice
@Slf4j
public class CommonExceptionHandler {

    /**
     * 自定义异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = CommonException.class)
    public R<String> errorHandler(CommonException e) {
        log.error("CommonException:code={},msg={}", e.getResultEnum().getCode(), e.getResultEnum().getMsg());
        return R.parse(e.getResultEnum());
    }

    /**
     * 未知异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public R<String> commonErrorHandler(Exception e) {
        log.error("UnKnownException:msg={}", e.getMessage(),e);
        return R.parse(ResultsEnum.SERVER_UNEXCEPTION_ERROR);
    }
}
