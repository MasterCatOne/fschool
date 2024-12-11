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
@TableName("students")
public class Students implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "student_id", type = IdType.AUTO)
    private Long studentId;

    /**
     * 作业id
     */
    @TableField("homework_id")
    private Long homeworkId;

    /**
     * 班级id
     */
    @TableField("class_id")
    private Long classId;

    /**
     * 班主任id
     */
    @TableField("teacher_id")
    private Long teacherId;

    /**
     * 家长id
     */
    @TableField("parent_id")
    private Long parentId;

    /**
     * 姓名
     */
    @TableField("student_name")
    private String studentName;

    /**
     * 年龄
     */
    @TableField("student_age")
    private Integer studentAge;

    /**
     * 学生密码
     */
    @TableField("student_pwd")
    private String studentPwd;

    /**
     * 角色
     */
    @TableField("role")
    private String role;

    /**
     * 0表示女，1表示男
     */
    @TableField("student_sex")
    private Integer studentSex;

    /**
     * 成绩
     */
    @TableField("score")
    private Integer score;

    /**
     * 评语
     */
    @TableField("comment")
    private String comment;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 盐，用于个人敏感信息处理
     */
    @TableField("secret")
    private String secret;
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
     *
     */
    @TableLogic
    @TableField("is_deleted")
    private Byte isDeleted;
    /**
     * 0表示女，1表示男
     */
    @TableField("is_online")
    private Byte isOnline;
    /**
     * 学号
     */
    @TableField("xuehao")
    private String xuehao;

}
