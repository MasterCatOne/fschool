package com.example.fschool.model.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author lirui
 * @since 2024-12-08
 */
@Getter
@Setter
@TableName("news")
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 新闻id
     */
    @TableId(value = "new_id", type = IdType.AUTO)
    private Long newId;

    /**
     * 教师id
     */
    @TableField("teacher_id")
    private Long teacherId;

    /**
     * 新闻标题
     */
    @TableField("new_title")
    private String newTitle;

    /**
     * 新闻的内容
     */
    @TableField("new_content")
    private String newContent;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 跟新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    /**
     * 新闻图片
     */
    @TableField("new_img")
    private String newImg;

    /**
     * 逻辑删除字段	
     */
    @TableLogic
    @TableField("is_deleted")
    private Byte isDeleted;
}
