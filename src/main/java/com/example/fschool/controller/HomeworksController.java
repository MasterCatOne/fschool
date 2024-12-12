package com.example.fschool.controller;

import com.example.fschool.model.dto.HomeworkDTO;
import com.example.fschool.model.po.Homeworks;
import com.example.fschool.model.query.HomeworkPageQuery;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.impl.HomeworksServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    /**
     *作业的添加
     */
    @PutMapping("/add")
    public ResponseVO add(@RequestBody HomeworkDTO homeworkDTO) {
        Homeworks homeworks=new Homeworks();
        BeanUtils.copyProperties(homeworkDTO,homeworks);
        return homeworksService.saveHomework(homeworks);
    }
    /**
     * 作业的删除
     */
    @DeleteMapping("/delete/{id}")
    public ResponseVO delete(@PathVariable Long id) {
        boolean removeById = homeworksService.removeById(id);
        return removeById? ResponseVO.ok():ResponseVO.error();
    }
    /**
     * 作业的修改
     */
    @PutMapping("/update")
    public ResponseVO update(@RequestBody HomeworkDTO homeworkDTO) {
        Homeworks homeworks=new Homeworks();
        BeanUtils.copyProperties(homeworkDTO,homeworks);
        return homeworksService.updateHomework(homeworks);
    }
    /**
     * 作业的分页查询
     */
    @GetMapping("/page")
    public ResponseVO queryUserPage(HomeworkPageQuery homeworkPageQuery) {
        return homeworksService.queryHomeworkPage(homeworkPageQuery);
    }
    /**
     * 根据作业id获取作业信息
     */
    @GetMapping("/getHomeworkById/{id}")
    public ResponseVO getHomeworkById(@PathVariable Long id) {
        return ResponseVO.ok().data("homework",homeworksService.getById(id));
    }

}
