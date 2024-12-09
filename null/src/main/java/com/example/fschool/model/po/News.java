package com.example.fschool.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author author
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
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 发布时间	
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 逻辑删除字段	
     */
    @TableField("is_deleted")
    private Byte isDeleted;
}
