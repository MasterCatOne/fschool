package com.example.fschool.controller;

import com.example.fschool.model.dto.ActivityDTO;
import com.example.fschool.model.po.Activitys;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.impl.ActivityServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * fschool/活动模块
 * @author lirui
 * @since 2024-12-08
 */
@CrossOrigin
@RestController
@RequestMapping("/api/activitys")
public class ActivityController {
    @Autowired
    private ActivityServiceImpl activityService;
    /**
     * 获取活动列表
     */
    @GetMapping("/list")
    public ResponseVO list(){
        List<Activitys> list = activityService.list();
        return ResponseVO.ok().data("list",list);
    }
    /**
     * 活动的添加
     */
    @PostMapping("/add")
    public ResponseVO add(@RequestBody ActivityDTO activityDTO){
        Activitys activitys=new Activitys();
        BeanUtils.copyProperties(activityDTO,activitys);
        return activityService.saveActivity(activitys);
    }
    /**
     * 活动的删除
     */
    @DeleteMapping("/delete/{id}")
    public ResponseVO delete(@PathVariable("id") Long id){
        boolean removeById = activityService.removeById(id);
        return removeById?ResponseVO.ok():ResponseVO.error();
    }
    /**
     * 活动的更新
     */
    @PutMapping("/update")
    public ResponseVO update(@RequestBody ActivityDTO activityDTO){
        Activitys activitys=new Activitys();
        BeanUtils.copyProperties(activityDTO,activitys);
        return activityService.updateActivity(activitys);
    }
}
