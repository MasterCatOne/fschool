package com.example.fschool.model.bo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherLoginBo {
    @TableField("teacher_id")
    private String teacherId;
    @TableField("teacher_name")
    private String teacharName;
    @TableField("gonghao")
    private String gonghao;
    private String role;
}