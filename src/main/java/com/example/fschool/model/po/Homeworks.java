package com.example.fschool.model.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDate;
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
@TableName("homeworks")
public class Homeworks implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 作业id
     */
    @TableId(value = "homework_id", type = IdType.AUTO)
    private Long homeworkId;

    /**
     * 教师id
     */
    @TableField("teacher_id")
    private Long teacherId;

    /**
     * 班级id
     */
    @TableField("class_id")
    private Long classId;

    /**
     * 作业标题
     */
    @TableField("homework_title")
    private String homeworkTitle;

    /**
     * 作业的内容
     */
    @TableField("homework_content")
    private String homeworkContent;

    /**
     * 截止日期
     */
    @TableField("deadline")
    private LocalDate deadline;

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
     * 逻辑删除字段	
     */
    @TableLogic
    @TableField("is_deleted")
    private Byte isDeleted;
}
