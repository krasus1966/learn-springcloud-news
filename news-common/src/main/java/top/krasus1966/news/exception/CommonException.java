package top.krasus1966.news.exception;

import top.krasus1966.news.enums.ICommonEnum;

/**
 * 通用异常处理
 *
 * @author Krasus1966
 * @date 2020/10/28 17:33
 **/
public class CommonException extends RuntimeException {

    private final ICommonEnum errorEnum;

    public CommonException(ICommonEnum errorEnum) {
        super("code:{"+errorEnum.getCode()+"},message:{"+errorEnum.getMsg()+"}");
        this.errorEnum = errorEnum;
    }

    public ICommonEnum getErrorEnum() {
        return errorEnum;
    }
}
