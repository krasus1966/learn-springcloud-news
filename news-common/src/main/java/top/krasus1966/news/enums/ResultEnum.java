package top.krasus1966.news.enums;

import top.krasus1966.news.result.StaticConstant;

/**
 * @author Krasus1966
 * @date 2020/10/8 21:38
 **/
public enum ResultEnum  implements ICommonEnum {

    /**
     * 返回结果
     */
    SUCCESS(StaticConstant.STATUS_SUCCESS, "操作成功！"),
    FAILED(StaticConstant.STATUS_FAIL,"操作失败！"),
    UN_LOGIN(302,"用户未登录！");

    private final Integer code;
    private final String msg;

    ResultEnum(int code, String msg) {
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
