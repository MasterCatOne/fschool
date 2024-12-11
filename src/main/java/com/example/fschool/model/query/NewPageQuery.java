package com.example.fschool.model.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NewPageQuery extends PageQuery{
    private String newsName;
    private String teacherId;
}
