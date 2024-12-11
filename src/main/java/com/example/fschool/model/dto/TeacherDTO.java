package com.example.fschool.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.example.fschool.model.po.Students;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class TeacherDTO {
    @TableId("teacher_id")
    private Long teacherId;

    /**
     * 班级id
     */
    @TableField("class_id")
    private Long classId;

    /**
     * 姓名
     */
    @TableField("teacher_name")
    private String teacherName;

    /**
     * 年龄
     */
    @TableField("teacher_age")
    private Integer teacherAge;

    /**
     * 密码
     */
    @TableField("teacher_pwd")
    private String teacherPwd;

    /**
     * 手机号码
     */
    @TableField("teacher_phone")
    private String teacherPhone;


    /**
     * 0表示女，1表示男
     */
    @TableField("teacher_sex")
    private Integer teacherSex;


    /**
     * 工号
     */
    @TableField("gonghao")
    private String gonghao;
    //    老师的学生
    @TableField(exist = false)
    private List<Students> studentsList;
}
