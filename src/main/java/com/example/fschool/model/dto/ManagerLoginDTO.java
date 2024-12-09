package com.example.fschool.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ManagerLoginDTO {



    /**
     * 密码
     */
    @TableField("manager_pwd")
    private String managerPwd;

    /**
     * 账号
     */
    @TableField("account")
    private String account;
}
