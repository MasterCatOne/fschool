package com.example.fschool.model.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
@Data
@EqualsAndHashCode(callSuper = true)
public class ParentPageQuery extends PageQuery{
    private String account;
    private String parentName;
}