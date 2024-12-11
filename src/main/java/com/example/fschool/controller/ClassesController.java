package com.example.fschool.controller;

import com.example.fschool.model.dto.ClassesDTO;
import com.example.fschool.model.po.Classes;
import com.example.fschool.model.query.ClassPageQuery;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.impl.ClassesServiceImpl;
import com.example.fschool.service.impl.StudentsServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    /**
     * 班级的添加
     */
    @PostMapping("/add")
    public ResponseVO add(@RequestBody ClassesDTO classesDTO){
        Classes classes=new Classes();
        BeanUtils.copyProperties(classesDTO,classes);
        boolean save = classesService.save(classes);
        return save?ResponseVO.ok():ResponseVO.error();
    }
    /**
     * 班级的删除
     */
    @DeleteMapping("/delete/{id}")
    public ResponseVO delete(@PathVariable Long id){
        boolean removeById = classesService.removeById(id);
        return removeById?ResponseVO.ok():ResponseVO.error();
    }
    /**
     * 班级的更新
     */
    @PutMapping("/update")
    public ResponseVO update(@RequestBody ClassesDTO classesDTO){
        Classes classes=new Classes();
        BeanUtils.copyProperties(classesDTO,classes);
        boolean updateById = classesService.updateById(classes);
        return updateById?ResponseVO.ok():ResponseVO.error();
    }
    /**
     * 班级的分页查询
     */
    @GetMapping("/page")
    public ResponseVO queryUserPage(ClassPageQuery classPageQuery){
        return classesService.queryHomeworkPage(classPageQuery);
    }




}
