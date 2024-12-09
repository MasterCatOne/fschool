package com.example.fschool.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ManagerRegisterDTO {


    /**
     * 姓名
     */
    @TableField("manager_name")
    private String managerName;

    /**
     * 密码
     */
    @TableField("manager_pwd")
    private String managerPwd;

    /**
     * 角色
     */
    @TableField("role")
    private String role;


    /**
     * 账号
     */
    @TableField("account")
    private String account;
}
