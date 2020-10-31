package top.krasus1966.news.bo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;


/**
 * @author Krasus1966
 * @date 2020/10/28 21:39
 **/
@Data
@ApiModel(value="登陆注册信息", description="登陆注册信息")
public class RegistLoginBO {

    /**
     * 校验：
     * ：@Null 必须为空
     * ：@NotNull 不能为空（但可以是空字符串）
     * ：@NotBlank 不能为空，且trim后长度大于0，只能用于字符串
     * ：@AssertTrue 必须为true
     * ：@AssertFalse 必须为false
     * ：@Min(value) 必须数字，必须大于指定值
     * ：@Max(value) 必须数字，必须小于指定值
     * ：@DecimalMix(value) 必须数字，必须大于指定值
     * ：@DecimalMax(value) 必须数字，必须小于指定值
     * ：@Size(max,min) 元素大小必须在指定范围内
     * ：@Digits(integer,fraction) 必须是数字，并且在指定范围内
     * ：@Past 必须是过去的日期
     * ：@Future 必须在未来的日期
     * ：@Pattern(value) 必须符合正则表达式
     * ：@Email 必须是电子邮件地址
     * ：@Length 字符串长度在指定范围内
     * ：@NotEmpty 字符不能为空
     * ：@Range 元素必须在合适的范围之内
     */

    @ApiModelProperty(value = "手机号码")
    @NotBlank(message = "手机号码不能为空")
    private String mobile;

    @ApiModelProperty(value = "短信验证码")
    @NotBlank(message = "短信验证码不能为空")
    private String smsCode;
}
