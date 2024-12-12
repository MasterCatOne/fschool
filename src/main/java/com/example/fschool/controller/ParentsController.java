package com.example.fschool.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fschool.model.dto.ParentDTO;
import com.example.fschool.model.dto.ParentLoginDTO;
import com.example.fschool.model.dto.ParentRegisterDTO;
import com.example.fschool.model.po.News;
import com.example.fschool.model.po.Parents;
import com.example.fschool.model.po.Students;
import com.example.fschool.model.query.ParentPageQuery;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.impl.ParentsServiceImpl;
import com.example.fschool.service.impl.StudentsServiceImpl;
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
    @Autowired
    private StudentsServiceImpl studentsService;
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

    /**
     * 家长的更新
     */
    @PutMapping("/update")
    public ResponseVO update(@RequestBody ParentDTO parentDTO) {
        return parentsService.updateByIdYa(parentDTO);
    }
    /**
     * 家长的删除
     */
    @DeleteMapping("/delete/{id}")
    public ResponseVO delete(@PathVariable("id") Long id) {
        boolean b = parentsService.removeById(id);
        return b ? ResponseVO.ok() : ResponseVO.error();
    }
    /**
     * 家长的分页查询
     */
    @GetMapping("/page")
    public ResponseVO queryUserPage(ParentPageQuery pageQuery) {
        return parentsService.queryParentPage(pageQuery);
    }
    /**
     * 家长获取自己孩子的信息
     */
    @GetMapping("/getChild/{id}")
    public ResponseVO getChildrenInfo(@PathVariable("id") Long id) {
        QueryWrapper<Students> queryWrapper=new QueryWrapper();
        queryWrapper.eq("parent_id",id);
        List<Students> studentsList = studentsService.list(queryWrapper);
        return ResponseVO.ok().data("list",studentsList);
    }

}
