package top.krasus1966.news.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Krasus1966
 * @date 2020/10/31 23:39
 **/
@ApiModel(value="用户信息BO", description="用户信息")
@Data
@EqualsAndHashCode(callSuper = false)
public class UpdateUserInfoBO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @NotBlank(message="用户id不能为空")
    private String id;

    @ApiModelProperty(value = "昵称，媒体号")
    @NotBlank(message = "用户昵称不能为空")
    @Length(max = 12,message = "昵称长度不能超过12位")
    private String nickname;

    @ApiModelProperty(value = "头像")
    @NotBlank(message = "用户头像不能为空")
    private String face;

    @ApiModelProperty(value = "真实姓名")
    @NotBlank(message = "真实姓名不能为空")
    private String realname;

    @ApiModelProperty(value = "邮箱地址")
    @NotBlank(message = "邮箱地址不能为空")
    @Email
    private String email;

    @ApiModelProperty(value = "性别 1:男  0:女  2:保密")
    @Min(value = 0,message = "性别选择不正确")
    @Max(value = 1,message = "性别选择不正确")
    @NotNull(message = "性别不能为空")
    private Integer sex;

    @ApiModelProperty(value = "生日")
    @NotNull(message = "生日不能为空")
    @JsonFormat(timezone = "GMT-8",pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @ApiModelProperty(value = "省份")
    @NotBlank(message = "省份不能为空")
    private String province;

    @ApiModelProperty(value = "城市")
    @NotBlank(message = "城市不能为空")
    private String city;

    @ApiModelProperty(value = "区县")
    @NotBlank(message = "区县不能为空")
    private String district;
}
