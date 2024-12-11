package com.example.fschool.model.dto;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class ClassesDTO {

    @TableId(value = "class_id", type = IdType.AUTO)
    private Long classId;

    /**
     * 班级昵称
     */
    @TableField("class_name")
    private String className;

    /**
     * 班级人数
     */
    @TableField("student_count")
    private Integer studentCount;


}
