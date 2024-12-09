package com.example.fschool.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TeacherRegisterDTO {

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
     * 角色
     */
    @TableField("role")
    private String role;

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
}
