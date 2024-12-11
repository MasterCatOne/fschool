package com.example.fschool.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fschool.mapper.HomeworksMapper;
import com.example.fschool.model.dto.HomeworkDTO;
import com.example.fschool.model.po.Homeworks;
import com.example.fschool.model.po.Teachers;
import com.example.fschool.model.query.HomeworkPageQuery;
import com.example.fschool.model.vo.PageVO;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.IHomeworksService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class HomeworksServiceImpl extends ServiceImpl<HomeworksMapper, Homeworks> implements IHomeworksService {
    @Override
    public ResponseVO queryHomeworkPage(HomeworkPageQuery homeworkPageQuery) {
        Page<Homeworks> sort = homeworkPageQuery.toMpPageDefaultSortByCreateTimeDesc();
        Page<Homeworks> page = lambdaQuery().eq(StringUtils.isNotBlank(homeworkPageQuery.getHomeworkTitle()),Homeworks::getHomeworkTitle, homeworkPageQuery.getHomeworkTitle())
                .like(ObjectUtils.isNotEmpty(homeworkPageQuery.getTeacherId()),Homeworks::getHomeworkId, homeworkPageQuery.getTeacherId())
                .page(sort);
        PageVO<Homeworks> teachersPageVO = new PageVO<>();
        teachersPageVO.of(page);
        return ResponseVO.ok().data("items",teachersPageVO);
    }
}
