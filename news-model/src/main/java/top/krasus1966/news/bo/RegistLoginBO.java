package top.krasus1966.news.bo;


import org.springframework.lang.NonNull;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Krasus1966
 * @date 2020/10/28 21:39
 **/
public class RegistLoginBO {

    /**
     * 校验：
     *  ：@Null 必须为空
     *  ：@NotNull 不能为空（但可以是空字符串）
     *  ：@NotBlank 不能为空，且trim后长度大于0
     *  ：@AssertTrue 必须为true
     *  ：@AssertFalse 必须为false
     *  ：@Min(value) 必须数字，必须大于指定值
     *  ：@Max(value) 必须数字，必须小于指定值
     *  ：@DecimalMix(value) 必须数字，必须大于指定值
     *  ：@DecimalMax(value) 必须数字，必须小于指定值
     *  ：@Size(max,min) 元素大小必须在指定范围内
     *  ：@Digits(integer,fraction) 必须是数字，并且在指定范围内
     *  ：@Past 必须是过去的日期
     *  ：@Future 必须在未来的日期
     *  ：@Pattern(value) 必须符合正则表达式
     *  ：@Email 必须是电子邮件地址
     *  ：@Length 字符串长度在指定范围内
     *  ：@NotEmpty 字符不能为空
     *  ：@Range 元素必须在合适的范围之内
     */

    @NotBlank(message="手机号码不能为空")
    private String mobile;
    @NotBlank(message = "短信验证码不能为空")
    private String smsCode;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSmsCode() {
        return smsCode;
    }

    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode;
    }
}
