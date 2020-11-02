package top.krasus1966.news.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author Krasus1966
 * @date 2020/11/2 21:08
 **/
@Data
public class AppUserVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "昵称，媒体号")
    private String nickname;

    @ApiModelProperty(value = "头像")
    private String face;

    @ApiModelProperty(value = "用户状态：0：未激活。 1：已激活：基本信息是否完善，真实姓名，邮箱地址，性别，生日，住址等，如果没有完善，则用户不能在作家中心操作，不能关注。2：已冻结。")
    @TableField("active_status")
    private Integer activeStatus;
}
