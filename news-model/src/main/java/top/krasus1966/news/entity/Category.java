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
 * 新闻资讯文章的分类（或者称之为领域）
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("category")
@ApiModel(value="Category对象", description="新闻资讯文章的分类（或者称之为领域）")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId
    private String id;

    @ApiModelProperty(value = "分类名，比如：科技，人文，历史，汽车等等")
    @TableField("name")
    private String name;

    @ApiModelProperty(value = "标签颜色")
    @TableField("tag_color")
    private String tagColor;


}
