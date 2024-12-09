package com.example.fschool.service.impl;

import com.example.fschool.model.po.Students;
import com.example.fschool.mapper.StudentsMapper;
import com.example.fschool.service.IStudentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-12-08
 */
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students> implements IStudentsService {

}
