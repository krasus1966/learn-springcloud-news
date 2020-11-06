package top.krasus1966.news.enums;

/**
 * 结果返回Enum
 *
 * @author Krasus1966
 * @date 2020/10/8 21:38
 **/
public enum ResultsEnum implements IResultsEnum {

    /**
     * 返回结果
     */
    SUCCESS(200, "操作成功！"),
    LOG_OUT_SUCCESS(200, "退出登录成功！"),
    UN_LOGIN(301,"用户未登录！"),
    NO_AUTH_INFO(302,"无权限！"),
    USER_FROZEN(303,"此用户已被冻结！"),
    SESSION_INVALID(304,"会话失效，请重新登录！"),
    SERVER_UNEXCEPTION_ERROR(500,"服务器内部错误！"),
    FAILED(501,"操作失败！"),
    LOG_OUT_FAIL(501, "退出登录成功！"),
    PARAM_NOT_VALID(503,"参数信息不合法！"),
    SMS_CODE_TIME_OUT(504,"验证码已过期"),
    SMS_CODE_ERROR(505,"验证码不匹配"),
    PASSPORT_TOO_BUSY(502,"发送短信太过频繁！"),

    ID_BLANK_ERROR(500,"id不能为空！"),
    ;

    private final Integer code;
    private final String msg;

    ResultsEnum(int code, String msg) {
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
