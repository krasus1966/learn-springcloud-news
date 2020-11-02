package top.krasus1966.news.result;

import lombok.Data;
import top.krasus1966.news.enums.IResultsEnum;
import top.krasus1966.news.exception.CommonException;

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
public class R<T> {
    private Integer code;
    private String msg;
    private T data;

    public R() {
    }

    public R(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public R(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 无数据返回格式
     *
     * @param code 状态码
     * @param msg 信息
     * @return @{code,msg}
     */
    public static <T> R<T> parse(Integer code, String msg) {
        return new R<>(code, msg);
    }

    /**
     * 有数据返回格式
     *
     * @param code 状态码
     * @param msg 信息
     * @param data 数据
     * @return @{code,msg,data}
     */
    public static <T> R<T> parse(Integer code, String msg, T data) {
        return new R<>(code, msg, data);
    }

    /**
     * 无数据返回格式
     *
     * @param resultEnum 封装返回信息
     * @return @{code,msg,data}
     */
    public static <T> R<T> parse(IResultsEnum resultEnum) {
        return new R<>(resultEnum.getCode(), resultEnum.getMsg());
    }

    /**
     * 有数据返回格式
     *
     * @param resultEnum 封装返回信息
     * @param data 数据
     * @return @{code,msg,data}
     */
    public static <T> R<T> parse(IResultsEnum resultEnum, T data) {
        return new R<>(resultEnum.getCode(), resultEnum.getMsg(), data);
    }

    /**
     * Map格式返回
     *
     * @param resultEnum 封装返回信息
     * @param data 数据
     * @param <T> 范型
     * @return @{code,msg,data}
     */
    public static <T> R<T> parse(IResultsEnum resultEnum, Map<?,?> data) {
        return new R<>(resultEnum.getCode(), resultEnum.getMsg(), (T) data);
    }

    /**
     * Set格式返回
     *
     * @param resultEnum 封装返回信息
     * @param data 数据
     * @param <T> 范型
     * @return @{code,msg,data}
     */
    public static <T> R<T> parse(IResultsEnum resultEnum, Set<T> data) {
        return new R<>(resultEnum.getCode(), resultEnum.getMsg(), (T) data);
    }

    /**
     * List格式返回
     *
     * @param resultEnum 封装返回信息
     * @param data 数据
     * @param <T> 范型
     * @return @{code,msg,data}
     */
    public static <T> R<T> parse(IResultsEnum resultEnum, List<T> data) {
        return new R<>(resultEnum.getCode(), resultEnum.getMsg(), (T) data);
    }

    /**
     * 异常返回
     *
     * @param error 封装返回信息
     * @return @{code,msg,data}
     */
    public static void error(IResultsEnum error) {
        throw new CommonException(error);
    }
}
