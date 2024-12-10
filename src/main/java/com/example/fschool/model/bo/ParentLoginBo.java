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
public class ParentLoginBo {
    @TableField("parent_id")
    private String parentID;
    @TableField("parent_name")
    private String parentName;
    @TableField("account")
    private String account;
    private String role;
}