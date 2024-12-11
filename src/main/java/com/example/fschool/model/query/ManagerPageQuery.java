package com.example.fschool.model.query;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ManagerPageQuery extends PageQuery{
    private String managerName;
}
