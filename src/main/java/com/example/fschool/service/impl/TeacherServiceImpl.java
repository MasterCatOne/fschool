package com.example.fschool.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fschool.mapper.TeachersMapper;
import com.example.fschool.model.po.Teachers;
import com.example.fschool.service.ITeachersService;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeachersMapper, Teachers> implements ITeachersService {
}
