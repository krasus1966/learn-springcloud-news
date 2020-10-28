package top.krasus1966.news.exception;

import top.krasus1966.news.enums.IResultEnum;

/**
 * 通用自定义异常
 *
 * @author Krasus1966
 * @date 2020/10/28 17:33
 **/
public class CommonException extends RuntimeException {

    private final IResultEnum resultEnum;

    public CommonException(IResultEnum resultEnum) {
        super("code:{"+ resultEnum.getCode()+"},message:{"+ resultEnum.getMsg()+"}");
        this.resultEnum = resultEnum;
    }

    public IResultEnum getResultEnum() {
        return resultEnum;
    }
}
