package top.krasus1966.news.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 粉丝表，用户与粉丝的关联关系，粉丝本质也是用户。
关联关系保存到es中，粉丝数方式和用户点赞收藏文章一样。累加累减都用redis来做。
字段与用户表有些冗余，主要用于数据可视化，数据一旦有了之后，用户修改性别和省份无法影响此表，只认第一次的数据。


 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("fans")
@ApiModel(value="Fans对象", description="粉丝表，用户与粉丝的关联关系，粉丝本质也是用户。 关联关系保存到es中，粉丝数方式和用户点赞收藏文章一样。累加累减都用redis来做。 字段与用户表有些冗余，主要用于数据可视化，数据一旦有了之后，用户修改性别和省份无法影响此表，只认第一次的数据。 ")
public class Fans implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId
    private String id;

    @ApiModelProperty(value = "作家用户id")
    @TableField("writer_id")
    private String writerId;

    @ApiModelProperty(value = "粉丝用户id")
    @TableField("fan_id")
    private String fanId;

    @ApiModelProperty(value = "粉丝头像")
    @TableField("face")
    private String face;

    @ApiModelProperty(value = "粉丝昵称")
    @TableField("fan_nickname")
    private String fanNickname;

    @ApiModelProperty(value = "粉丝性别")
    @TableField("sex")
    private Integer sex;

    @ApiModelProperty(value = "省份")
    @TableField("province")
    private String province;


}
