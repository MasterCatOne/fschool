package com.example.fschool.model.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class ParentLoginDTO {
    @TableField("account")
    private String account;
    @TableField("parent_pwd")
    private String parentPwd;
}
