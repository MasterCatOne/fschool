package com.example.fschool.controller;

import com.example.fschool.model.dto.StudentLoginDTO;
import com.example.fschool.model.dto.StudentRegisterDTO;
import com.example.fschool.model.po.Students;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.impl.StudentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * fschool/学生模块
 * @author lirui
 * @since 2024-12-08
 */
@CrossOrigin
@RestController
@RequestMapping("/api/students")
public class StudentsController {
    @Autowired
    private StudentsServiceImpl studentsService;
    /**
     * 查询所有学生信息
     */
    @RequestMapping("/list")
    public ResponseVO list() {
        List<Students> list = studentsService.list();
        return ResponseVO.ok().data("item",list);
    }
    /**
     * 学生注册
     */
    @PostMapping("/register")
    public ResponseVO register(@RequestBody StudentRegisterDTO registerDTO) {
        return studentsService.register(registerDTO);
    }
    /**
     * 学生登录
     */
    @PostMapping("/login")
    public ResponseVO login(@RequestBody StudentLoginDTO loginDTO) {
        return studentsService.login(loginDTO);
    }
}
