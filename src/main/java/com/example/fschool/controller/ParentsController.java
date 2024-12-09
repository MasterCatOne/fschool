package com.example.fschool.controller;

import com.example.fschool.model.dto.ParentLoginDTO;
import com.example.fschool.model.dto.ParentRegisterDTO;
import com.example.fschool.model.po.News;
import com.example.fschool.model.po.Parents;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.impl.ParentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * fschool/家长模块
 * @author lirui
 * @since 2024-12-08
 */
@CrossOrigin
@RestController
@RequestMapping("/api/parents")
public class ParentsController {
    @Autowired
    private ParentsServiceImpl parentsService;
    /**
     * 获取家长列表
     */
    @RequestMapping("/list")
    public ResponseVO list() {
        List<Parents> list = parentsService.list();
        return ResponseVO.ok().data("list",list);
    }
    /**
     * 家长注册
     */
    @PostMapping("/register")
    public ResponseVO register(@RequestBody ParentRegisterDTO parentRegisterDTO) {


       return parentsService.register(parentRegisterDTO);
    }
    /**
     * 家长登录
     */
    @PostMapping ("/login")
    public ResponseVO login(@RequestBody ParentLoginDTO parentLoginDTO) {
        return parentsService.login(parentLoginDTO);
    }


}
