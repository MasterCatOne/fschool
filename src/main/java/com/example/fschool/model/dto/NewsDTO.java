package com.example.fschool.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class NewsDTO {
    /**
     * 新闻id
     */
    @TableId("new_id")
    private Long newId;

    /**
     * 教师id
     */
    @TableField("teacher_id")
    private Long teacherId;

    /**
     * 新闻标题
     */
    @TableField("new_title")
    private String newTitle;
    /**
     * 新闻图片
     */
    @TableField("new_img")
    private String newImg;

    /**
     * 新闻的内容
     */
    @TableField("new_content")
    private String newContent;

}
