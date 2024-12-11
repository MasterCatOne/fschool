package com.example.fschool.model.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.omg.CORBA.INTERNAL;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentPageQuery extends PageQuery{
    private String xuehao;
    private String studentName;
    private Long classId;
}