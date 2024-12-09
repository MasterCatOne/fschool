package com.example.fschool.model.dto;


import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;


@Data
public class StudentRegisterDTO  {

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
     * 学号
     */
    @TableField("xuehao")
    private String xuehao;

    /**
     * 角色
     */
    @TableField("role")
    private String role;

    /**
     * 0表示女，1表示男
     */
    @TableField("student_sex")
    private Byte studentSex;


}
