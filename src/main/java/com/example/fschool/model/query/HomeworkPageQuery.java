package com.example.fschool.model.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class HomeworkPageQuery extends PageQuery{
    private Long teacherId;
    private String homeworkTitle;
    private Integer process;
}
