package com.example.fschool.model.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class StudentDTO {
    @TableId("student_id")
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
     * 评论
     */
    @TableField("comment")
    private String comment;

    /**
     * 学生密码
     */
    @TableField("student_pwd")
    private String studentPwd;
    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;


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
     * 学号
     */
    @TableField("xuehao")
    private String xuehao;
}
