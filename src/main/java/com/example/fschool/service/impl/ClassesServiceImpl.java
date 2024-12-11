package com.example.fschool.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fschool.mapper.ClassesMapper;
import com.example.fschool.model.po.Classes;
import com.example.fschool.model.po.Students;
import com.example.fschool.model.query.ClassPageQuery;
import com.example.fschool.model.vo.PageVO;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.IClassesService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes> implements IClassesService {
    @Override
    public ResponseVO queryHomeworkPage(ClassPageQuery classPageQuery) {
        Page<Classes> sort = classPageQuery.toMpPageDefaultSortByCreateTimeDesc();
        Page<Classes> page = lambdaQuery().eq(StringUtils.isNotBlank(classPageQuery.getClassName()),Classes::getClassName, classPageQuery.getClassName())
                .like(ObjectUtils.isNotEmpty(classPageQuery.getStudentCount()),Classes::getStudentCount, classPageQuery.getStudentCount())
                .page(sort);
        PageVO<Classes> userPageVo = new PageVO<>();
        userPageVo.of(page);
        return ResponseVO.ok().data("items",userPageVo);
    }
}
