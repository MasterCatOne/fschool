package com.example.fschool.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class StudentLoginDTO {
    @TableField("xuehao")
    private String xuehao;
    @TableField("student_pwd")
    private String studentPwd;
}
