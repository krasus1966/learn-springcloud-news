package top.krasus1966.news.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * 网站用户
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="AppUserVO对象", description="网站用户")
public class UserAccountVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "昵称，媒体号")
    private String nickname;

    @ApiModelProperty(value = "头像")
    private String face;

    @ApiModelProperty(value = "真实姓名")
    private String realname;

    @ApiModelProperty(value = "邮箱地址")
    private String email;

    @ApiModelProperty(value = "性别 1:男  0:女  2:保密")
    private Integer sex;

    @ApiModelProperty(value = "生日")
    private LocalDate birthday;

    @ApiModelProperty(value = "省份")
    private String province;

    @ApiModelProperty(value = "城市")
    private String city;

    @ApiModelProperty(value = "区县")
    private String district;
}
