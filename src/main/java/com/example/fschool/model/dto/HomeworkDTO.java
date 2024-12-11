package com.example.fschool.model.dto;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Data
public class HomeworkDTO {

    /**
     * 作业id
     */
    @TableId(value = "homework_id", type = IdType.AUTO)
    private Long homeworkId;

    /**
     * 教师id
     */
    @TableField("teacher_id")
    private Long teacherId;

    /**
     * 班级id
     */
    @TableField("class_id")
    private Long classId;

    /**
     * 作业标题
     */
    @TableField("homework_title")
    private String homeworkTitle;

    /**
     * 作业的内容
     */
    @TableField("homework_content")
    private String homeworkContent;

    /**
     * 截止日期
     */
    @TableField("deadline")
    private LocalDate deadline;

}
