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
 * 文章资讯表
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("article")
@ApiModel(value = "Article对象", description = "文章资讯表")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId
    private String id;

    @ApiModelProperty(value = "文章标题")
    @TableField("title")
    private String title;

    @ApiModelProperty(value = "文章内容，长度不超过9999，需要在前后端判断")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "文章所属分类id")
    @TableField("category_id")
    private Integer categoryId;

    @ApiModelProperty(value = "文章类型，1：图文（1张封面），2：纯文字")
    @TableField("article_type")
    private Integer articleType;

    @ApiModelProperty(value = "文章封面图，article_type=1 的时候展示")
    @TableField("article_cover")
    private String articleCover;

    @ApiModelProperty(value = "是否是预约定时发布的文章，1：预约（定时）发布，0：即时发布    在预约时间到点的时候，把1改为0，则发布")
    @TableField("is_appoint")
    private Integer isAppoint;

    @ApiModelProperty(value = "文章状态，1：审核中（用户已提交），2：机审结束，等待人工审核，3：审核通过（已发布），4：审核未通过；5：文章撤回（已发布的情况下才能撤回和删除）")
    @TableField("article_status")
    private Integer articleStatus;

    @ApiModelProperty(value = "发布者用户id")
    @TableField("publish_user_id")
    private String publishUserId;

    @ApiModelProperty(value = "文章发布时间（也是预约发布的时间）")
    @TableField("publish_time")
    private LocalDateTime publishTime;

    @ApiModelProperty(value = "用户累计点击阅读数（喜欢数）（点赞） - 放redis")
    @TableField("read_counts")
    private Integer readCounts;

    @ApiModelProperty(value = "文章评论总数。评论防刷，距离上次评论需要间隔时间控制几秒")
    @TableField("comment_counts")
    private Integer commentCounts;

    @TableField("mongo_file_id")
    private String mongoFileId;

    @ApiModelProperty(value = "逻辑删除状态，非物理删除，1：删除，0：未删除")
    @TableField("is_delete")
    private Integer isDelete;

    @ApiModelProperty(value = "文章的创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "文章的修改时间")
    @TableField("update_time")
    private LocalDateTime updateTime;


}
