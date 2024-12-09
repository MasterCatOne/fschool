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
public class StudentLoginBo {
    @TableField("student_id")
    private String studentID;
    @TableField("student_name")
    private String studentName;
    @TableField("account")
    private String account;


}
