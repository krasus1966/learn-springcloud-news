package top.krasus1966.news.result;

import lombok.Data;

/**
 * @author Krasus1966
 * @date 2020/10/8 21:42
 **/
@Data
public class Results<T> {
    private Integer code;
    private String msg;
    private T data;

    public Results() {
    }

    public Results(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Results(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 无数据返回格式
     *
     * @param code
     * @param msg
     * @return
     */
    public static <T> Results<T> parse(Integer code, String msg) {
        return new Results<T>(code, msg);
    }

    /**
     * 有数据返回格式
     *
     * @param code
     * @param msg
     * @return
     */
    public static <T> Results<T> parse(Integer code, String msg, T data) {
        return new Results<T>(code, msg, data);
    }

    /**
     * 无数据返回格式
     *
     * @param resultEnum
     * @return
     */
    public static <T> Results<T> parse(ResultEnum resultEnum) {
        return new Results<T>(resultEnum.getCode(), resultEnum.getMsg());
    }

    /**
     * 有数据返回格式
     *
     * @param resultEnum
     * @param data
     * @return
     */
    public static <T> Results<T> parse(ResultEnum resultEnum, T data) {
        return new Results<T>(resultEnum.getCode(), resultEnum.getMsg(), data);
    }
}
