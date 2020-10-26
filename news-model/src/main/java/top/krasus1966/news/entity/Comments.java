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
 * 文章评论表
 * </p>
 *
 * @author krasus1966
 * @since 2020-10-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("comments")
@ApiModel(value="Comments对象", description="文章评论表")
public class Comments implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "id")
    @TableId
    private String id;

    @ApiModelProperty(value = "评论的文章是哪个作者的关联id")
    @TableField("writer_id")
    private String writerId;

    @ApiModelProperty(value = "如果是回复留言，则本条为子留言，需要关联查询")
    @TableField("father_id")
    private String fatherId;

    @ApiModelProperty(value = "回复的那个文章id")
    @TableField("article_id")
    private String articleId;

    @ApiModelProperty(value = "冗余文章标题，宽表处理，非规范化的sql思维，对于几百万文章和几百万评论的关联查询来讲，性能肯定不行，所以做宽表处理，从业务角度来说，文章发布以后不能随便修改标题和封面的")
    @TableField("article_title")
    private String articleTitle;

    @ApiModelProperty(value = "文章封面")
    @TableField("article_cover")
    private String articleCover;

    @ApiModelProperty(value = "发布留言的用户id")
    @TableField("comment_user_id")
    private String commentUserId;

    @ApiModelProperty(value = "冗余用户昵称，非一致性字段，用户修改昵称后可以不用同步")
    @TableField("comment_user_nickname")
    private String commentUserNickname;

    @ApiModelProperty(value = "冗余的用户头像")
    @TableField("comment_user_face")
    private String commentUserFace;

    @ApiModelProperty(value = "留言内容")
    @TableField("content")
    private String content;

    @ApiModelProperty(value = "留言时间")
    @TableField("create_time")
    private LocalDateTime createTime;


}
