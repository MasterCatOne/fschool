package com.example.fschool.model.dto;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class StudentRegisterDTO  {

    /**
     * 班级id
     */
    @TableField("class_id")
    private Long classId;



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


}
