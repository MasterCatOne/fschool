package com.example.fschool.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ParentRegisterDTO {
    /**
     * 班级id
     */
    @TableField("class_id")
    private Long classId;



    /**
     * 密码
     */
    @TableField("parent_pwd")
    private String parentPwd;



    /**
     * 账号
     */
    @TableField("account")
    private String account;
}
