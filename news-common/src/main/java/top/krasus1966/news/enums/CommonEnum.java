package top.krasus1966.news.enums;

/**
 * @author Krasus1966
 * @date 2020/10/28 17:45
 **/
public enum CommonEnum implements ICommonEnum {
    /**
     * 通用enum
     */
    ;



    private final Integer code;
    private final String msg;

    CommonEnum(Integer code, String msg) {
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
