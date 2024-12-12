package com.example.fschool.model.query;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.util.pattern.PathPattern;

@Data
@EqualsAndHashCode(callSuper = true)
public class ManagerPageQuery extends PageQuery{
    private String managerName;
    private String account;
}
