package com.example.fschool.controller;

import com.example.fschool.model.po.Parents;
import com.example.fschool.model.po.Teachers;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.ITeachersService;
import com.example.fschool.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * fschool/教师模块
 * @author lirui
 * @since 2024-12-08
 */
@CrossOrigin
@RestController
@RequestMapping("/api/teachers")
public class TeachersController {
    @Autowired
    private TeacherServiceImpl teacherService;
    /**
     * 获取教师列表
     * @return
     */
    @RequestMapping("/list")
    public ResponseVO list() {
        List<Teachers> list = teacherService.list();
        return ResponseVO.ok().data("list",list);
    }


}
