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
 * @author novel
 * @since 2024-12-12
 */
@Getter
@Setter
@TableName("activity")
public class Activitys implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 活动表主键
     */
    @TableId(value = "activity_id", type = IdType.AUTO)
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
    @TableField(value = "activity_time" ,fill = FieldFill.INSERT)
    private LocalDateTime activityTime;

    /**
     * 活动图片
     */
    @TableField("activity_img")
    private String activityImg;
}
