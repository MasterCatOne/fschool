package com.example.fschool.model.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ClassPageQuery extends PageQuery{
    private String className;
    private Integer studentCount;
}
