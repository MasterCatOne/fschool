package com.example.fschool.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fschool.model.dto.StudentDTO;
import com.example.fschool.model.dto.StudentLoginDTO;
import com.example.fschool.model.dto.StudentRegisterDTO;
import com.example.fschool.model.po.Students;
import com.example.fschool.model.query.StudentPageQuery;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.impl.StudentsServiceImpl;
import com.example.fschool.utils.RandomUtils;
import com.example.fschool.utils.SaveFile;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
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
    /**
     * 分页查询
     * @param pageQuery 分页查询对象
     */
    @GetMapping("/page")
    public ResponseVO queryUserPage(StudentPageQuery pageQuery){
        return studentsService.queryUserPage(pageQuery);
    }
    /**
     * 修改学生信息
     */
    @PutMapping("/update")
    public ResponseVO update(@RequestBody StudentDTO studentDTO ){
//        , @RequestParam(value = "photo",required = false) MultipartFile photo, HttpServletRequest request)
        String realPath = "F:\\experiment2\\FamilySchool-backed\\fschool\\src\\main\\resources\\static";
        System.out.println(realPath);
//        SaveFile.saveFile(photo, realPath);
//        String s = realPath +File.separator+ photo.getOriginalFilename();
//        studentDTO.setAvatar("images/"+photo.getOriginalFilename());
//        System.out.println(s);
        return studentsService.updateByidYa(studentDTO);
    }

    /**
     * 删除学生
     */
    @DeleteMapping("/delete/{id}")
    public ResponseVO delete(@PathVariable Long id) {
        boolean b = studentsService.removeById(id);
        return b?ResponseVO.ok():ResponseVO.error();
    }
    /**
     * 查询某个学生信息
     */
    @GetMapping("/get/{xuehao}")
    public ResponseVO getStudent(@PathVariable("xuehao") String xuehao) {
        QueryWrapper queryWrapper=new QueryWrapper();
        queryWrapper.eq("xuehao",xuehao);
        Students one = studentsService.getOne(queryWrapper);
        return ResponseVO.ok().data("item",one);
    }
}
