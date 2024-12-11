package com.example.fschool.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ParentDTO {
    @TableId("parent_id")
    private Long parentId;

    /**
     * 姓名
     */
    @TableField("parent_name")
    private String parentName;

    /**
     * 年龄
     */
    @TableField("parent_age")
    private Integer parentAge;

    /**
     * 密码
     */
    @TableField("parent_pwd")
    private String parentPwd;

    /**
     * 手机号码
     */
    @TableField("parent_phone")
    private String parentPhone;

    /**
     * 0表示女，1表示男
     */
    @TableField("parent_sex")
    private Integer parentSex;

    /**
     * 账号
     */
    @TableField("account")
    private String account;
}
