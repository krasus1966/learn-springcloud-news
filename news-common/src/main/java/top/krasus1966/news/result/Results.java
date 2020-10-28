package top.krasus1966.news.result;

import lombok.Data;
import top.krasus1966.news.enums.IResultEnum;
import top.krasus1966.news.enums.ResultEnum;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 通用返回封装
 *
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
    public static <T> Results<T> parse(IResultEnum resultEnum) {
        return new Results<T>(resultEnum.getCode(), resultEnum.getMsg());
    }

    /**
     * 有数据返回格式
     *
     * @param resultEnum
     * @param data
     * @return
     */
    public static <T> Results<T> parse(IResultEnum resultEnum, T data) {
        return new Results<T>(resultEnum.getCode(), resultEnum.getMsg(), data);
    }

    /**
     * Map格式返回
     *
     * @param resultEnum
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Results<T> parse(IResultEnum resultEnum, Map data) {
        return new Results<T>(resultEnum.getCode(), resultEnum.getMsg(), (T) data);
    }

    /**
     * Set格式返回
     *
     * @param resultEnum
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Results<T> parse(IResultEnum resultEnum, Set data) {
        return new Results<T>(resultEnum.getCode(), resultEnum.getMsg(), (T) data);
    }

    /**
     * List格式返回
     *
     * @param resultEnum
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Results<T> parse(IResultEnum resultEnum, List data) {
        return new Results<T>(resultEnum.getCode(), resultEnum.getMsg(), (T) data);
    }
}
