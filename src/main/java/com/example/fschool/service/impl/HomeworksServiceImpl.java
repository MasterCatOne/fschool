package com.example.fschool.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fschool.mapper.HomeworksMapper;
import com.example.fschool.model.po.Homeworks;
import com.example.fschool.service.IHomeworksService;
import org.springframework.stereotype.Service;

@Service
public class HomeworksServiceImpl extends ServiceImpl<HomeworksMapper, Homeworks> implements IHomeworksService {
}
