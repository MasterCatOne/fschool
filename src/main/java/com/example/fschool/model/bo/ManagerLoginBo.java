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
public class ManagerLoginBo {
    @TableField("manager_id")
    private String studentID;
    @TableField("manager_name")
    private String studentName;
    @TableField("account")
    private String account;
    private String role;

}