package com.example.fschool.service;

import com.example.fschool.model.dto.TeacherDTO;
import com.example.fschool.model.dto.TeacherLoginDTO;
import com.example.fschool.model.dto.TeacherRegisterDTO;
import com.example.fschool.model.po.Teachers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fschool.model.vo.ResponseVO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lirui
 * @since 2024-12-08
 */
public interface ITeachersService extends IService<Teachers> {


    ResponseVO register(TeacherRegisterDTO teacherRegisterDTO);

    ResponseVO login(TeacherLoginDTO teacherRegisterDTO);

    List<Teachers> getTeacherList(Long teacherId);


    ResponseVO updateByIdYa(TeacherDTO teacherDTO);
}
