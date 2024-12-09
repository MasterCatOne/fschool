package com.example.fschool.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fschool.mapper.ParentsMapper;
import com.example.fschool.model.po.Parents;
import com.example.fschool.service.IParentsService;
import org.springframework.stereotype.Service;

@Service
public class ParentsServiceImpl extends ServiceImpl<ParentsMapper, Parents> implements IParentsService {
}
