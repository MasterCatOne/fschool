package com.example.fschool.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@TableName("parents")
public class Parents implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "parent_id", type = IdType.AUTO)
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
     * 角色
     */
    @TableField("role")
    private String role;

    /**
     * 0表示女，1表示男
     */
    @TableField("parent_sex")
    private Integer parentSex;

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
    @TableField("is_deleted")
    private Byte isDeleted;
    /**
     * 账号
     */
    @TableField("account")
    private String account;
}
