package com.example.fschool.controller;

import com.example.fschool.model.po.Classes;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.impl.ClassesServiceImpl;
import com.example.fschool.service.impl.StudentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * fschool/班级模块
 * @author lirui
 * @since 2024-12-08
 */
@CrossOrigin
@RestController
@RequestMapping("/api/classes")
public class ClassesController {
    @Autowired
    private ClassesServiceImpl classesService;
    /**
     * 查询所有班级信息
     */
    @RequestMapping("/list")
    public ResponseVO list(){
        List<Classes> list = classesService.list();
        return ResponseVO.ok().data("list",list);
    }



}
