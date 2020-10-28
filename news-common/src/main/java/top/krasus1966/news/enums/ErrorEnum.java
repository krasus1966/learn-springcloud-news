package top.krasus1966.news.enums;

import top.krasus1966.news.result.StaticConstant;

/**
 * @author Krasus1966
 * @date 2020/10/28 17:43
 **/
public enum  ErrorEnum implements ICommonEnum {
    /**
     * 异常错误通用
     */
    PASSPORT_TOO_BUSY(StaticConstant.STATUS_FAIL,"发送短信太过频繁！"),
    SERVER_UNEXCEPTION_ERROR(StaticConstant.STATUS_FAIL,"服务器出现未知错误")

    ;



    private final Integer code;
    private final String msg;

    ErrorEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
