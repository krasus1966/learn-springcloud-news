package top.krasus1966.news.result;

import lombok.Data;

/**
 * @author Krasus1966
 * @date 2020/10/8 21:38
 **/
public enum ResultEnum {

    /**
     * 返回结果
     */
    SUCCESS(200, "操作成功！"),
    FAILED(500,"操作失败！"),
    UN_LOGIN(302,"用户未登录！");

    private Integer code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
