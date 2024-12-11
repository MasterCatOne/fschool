package com.example.fschool.service;

import com.example.fschool.model.dto.StudentLoginDTO;
import com.example.fschool.model.dto.StudentRegisterDTO;
import com.example.fschool.model.po.Students;
import com.baomidou.mybatisplus.extension.service.IService;

import com.example.fschool.model.query.StudentPageQuery;
import com.example.fschool.model.vo.ResponseVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lirui
 * @since 2024-12-08
 */
public interface IStudentsService extends IService<Students> {


    ResponseVO register(StudentRegisterDTO registerDTO);

    ResponseVO login(StudentLoginDTO loginDTO);

    ResponseVO queryUserPage(StudentPageQuery pageQuery);
}
