package com.example.fschool.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

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
@TableName("teachers")
public class Teachers implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "teacher_id", type = IdType.AUTO)
    private Long teacherId;

    /**
     * 班级id
     */
    @TableField("class_id")
    private Long classId;

    /**
     * 姓名
     */
    @TableField("teacher_name")
    private String teacherName;

    /**
     * 年龄
     */
    @TableField("teacher_age")
    private Integer teacherAge;

    /**
     * 密码
     */
    @TableField("teacher_pwd")
    private String teacherPwd;

    /**
     * 手机号码
     */
    @TableField("teacher_phone")
    private String teacherPhone;

    /**
     * 角色
     */
    @TableField("role")
    private String role;

    /**
     * 0表示女，1表示男
     */
    @TableField("teacher_sex")
    private Integer teacherSex;

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
     * 工号
     */
    @TableField("gonghao")
    private String gonghao;
//    老师的学生
    @TableField(exist = false)
    private List<Students> studentsList;

}
