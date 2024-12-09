package com.example.fschool.controller;

import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.impl.HomeworksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * fschool/作业模块
 * @author lirui
 * @since 2024-12-08
 */
@CrossOrigin
@RestController
@RequestMapping("/api/homeworks")
public class HomeworksController {
    @Autowired
    private HomeworksServiceImpl homeworksService;
    /**
     * 获取作业列表
     */
    @RequestMapping("/list")
    public ResponseVO list() {
        return ResponseVO.ok().data("list",homeworksService.list());
    }

}
