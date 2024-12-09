package com.example.fschool.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fschool.mapper.ClassesMapper;
import com.example.fschool.model.po.Classes;
import com.example.fschool.service.IClassesService;
import org.springframework.stereotype.Service;

@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes> implements IClassesService {
}
