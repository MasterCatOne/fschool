package com.example.fschool.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TeacherLoginDTO {



    /**
     * 密码
     */
    @TableField("teacher_pwd")
    private String teacherPwd;


    /**
     * 工号
     */
    @TableField("gonghao")
    private String gonghao;
}
