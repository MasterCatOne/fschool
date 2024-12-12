package com.example.fschool.model.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ActivityDTO {

    /**
     * 活动表主键
     */
    @TableId("activity_id")
    private Long activityId;

    /**
     * 活动标题
     */
    @TableField("activity_title")
    private String activityTitle;

    /**
     * 活动内容
     */
    @TableField("activity_content")
    private String activityContent;

    /**
     * 活动时间
     */
//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @TableField("activity_time")
    private LocalDate activityTime;

    /**
     * 活动图片
     */
    @TableField("activity_img")
    private String activityImg;
}
