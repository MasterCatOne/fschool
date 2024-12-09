package com.example.fschool.controller;

import com.example.fschool.model.dto.ManagerLoginDTO;
import com.example.fschool.model.dto.ManagerRegisterDTO;
import com.example.fschool.model.po.Managers;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.impl.ManagersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * fschool/管理员模块
 * @author lirui
 * @since 2024-12-08
 */
@CrossOrigin
@RestController
@RequestMapping("/api/managers")
public class ManagersController {
    @Autowired
    private ManagersServiceImpl managersService;
    /**
     * 获取管理员列表
     */
    @RequestMapping("/list")
    public ResponseVO list() {
        List<Managers> list = managersService.list();
        return ResponseVO.ok().data("list",list);
    }
    /**
     * 管理员登录
     */
    @PostMapping("/login")
    public ResponseVO login(@RequestBody ManagerLoginDTO managerLoginDTO) {
        return managersService.login(managerLoginDTO);
    }
    /**
     * 管理员注册
     */
    @PostMapping("/register")
    public ResponseVO register(@RequestBody ManagerRegisterDTO managerRegisterDTO) {
        return managersService.register(managerRegisterDTO);
    }

}
