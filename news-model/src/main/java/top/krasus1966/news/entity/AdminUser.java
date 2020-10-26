package top.krasus1966.news.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 运营管理平台的admin级别用户
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("admin_user")
@ApiModel(value="AdminUser对象", description="运营管理平台的admin级别用户")
public class AdminUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId
    private String id;

    @ApiModelProperty(value = "用户名")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "密码")
    @TableField("password")
    private String password;

    @ApiModelProperty(value = "人脸入库图片信息，该信息保存到mongoDB的gridFS中")
    @TableField("face_id")
    private String faceId;

    @ApiModelProperty(value = "管理人员的姓名")
    @TableField("admin_name")
    private String adminName;

    @ApiModelProperty(value = "创建时间 创建时间")
    @TableField("created_time")
    private LocalDateTime createdTime;

    @ApiModelProperty(value = "更新时间 更新时间")
    @TableField("updated_time")
    private LocalDateTime updatedTime;


}
