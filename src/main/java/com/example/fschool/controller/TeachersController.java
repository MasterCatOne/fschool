package com.example.fschool.controller;

import com.example.fschool.mapper.TeachersMapper;
import com.example.fschool.model.dto.TeacherLoginDTO;
import com.example.fschool.model.dto.TeacherRegisterDTO;
import com.example.fschool.model.po.Parents;
import com.example.fschool.model.po.Teachers;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.ITeachersService;
import com.example.fschool.service.impl.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    private TeachersMapper teachersMapper;
    /**
     * 获取教师列表
     * @return
     */
    @RequestMapping("/list")
    public ResponseVO list() {
        List<Teachers> list = teacherService.list();
        return ResponseVO.ok().data("list", list);
    }
    /**
     * 获取教师列表2
     * @return
     */
    @RequestMapping("/list2/{id}")
    public ResponseVO list2(@PathVariable("id") Long teacherid) {
        List<Teachers> teacherList = teacherService.getTeacherList(teacherid);
        return ResponseVO.ok().data("list", teacherList);
    }

    /**
     * 教师的注册
     */
    @PostMapping("/register")
    public ResponseVO register(@RequestBody TeacherRegisterDTO teacherRegisterDTO) {
        return teacherService.register(teacherRegisterDTO);
    }
    /**
     * 教师的登录
     */
    @PostMapping("/login")
    public ResponseVO login(@RequestBody TeacherLoginDTO teacherRegisterDTO) {
        return teacherService.login(teacherRegisterDTO);
    }

}
