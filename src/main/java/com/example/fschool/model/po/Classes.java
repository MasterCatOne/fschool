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
@TableName("classes")
public class Classes implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "class_id", type = IdType.AUTO)
    private Long classId;

    /**
     * 班级昵称
     */
    @TableField("class_name")
    private String className;

    /**
     * 班级人数
     */
    @TableField("student_count")
    private Integer studentCount;
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
     * 删除标记（1:不可用 0:可用）
     */
    @TableLogic
    @TableField("is_deleted")
    private Byte isDeleted;
}
