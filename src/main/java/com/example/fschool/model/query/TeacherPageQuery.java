package com.example.fschool.model.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TeacherPageQuery extends PageQuery{
    private String teacherName;
    private String gonghao;

}
