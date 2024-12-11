package com.example.fschool.model.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author lirui
 * @since 2024-12-08
 */
@Getter
@Setter
@TableName("managers")
public class Managers implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "manager_id", type = IdType.AUTO)
    private Long managerId;

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
     * 盐，用于个人敏感信息处理
     */
    @TableField("secret")
    private String secret;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 跟新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 删除标记（1:不可用 0:可用）
     */
    @TableLogic
    @TableField("is_deleted")
    private Byte isDeleted;
    /**
     * 账号
     */
    @TableField("account")
    private String account;
}
