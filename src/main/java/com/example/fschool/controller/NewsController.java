package com.example.fschool.controller;

import com.example.fschool.model.dto.NewsDTO;
import com.example.fschool.model.po.News;
import com.example.fschool.model.query.NewPageQuery;
import com.example.fschool.model.query.StudentPageQuery;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.impl.NewsServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * fschool/新闻模块
 * @author lirui
 * @since 2024-12-08
 */
@CrossOrigin
@RestController
@RequestMapping("/api/news")
public class NewsController {
    @Autowired
    private NewsServiceImpl newsService;
    /**
     * 获取新闻列表
     */
    @RequestMapping("/list")
    public ResponseVO list() {
        List<News> list = newsService.list();
        return ResponseVO.ok().data("list",list);
    }
    /**
     * 新闻的增加方法
     */
    @PostMapping("/add")
    public ResponseVO add(@RequestBody NewsDTO newsDTO) {
        News news=new News();
        BeanUtils.copyProperties(newsDTO,news);
        return newsService.saveNews(news);
    }
    /**
     * 新闻的删除方法
     */
    @DeleteMapping("/delete/{id}")
    public ResponseVO delete(@PathVariable Long id) {
        boolean removeById = newsService.removeById(id);
        return removeById?ResponseVO.ok():ResponseVO.error();
    }
    /**
     * 新闻的修改方法
     */
    @PutMapping("/update")
    public ResponseVO update(@RequestBody NewsDTO newsDTO) {
        News news=new News();
        BeanUtils.copyProperties(newsDTO,news);
        return newsService.updateNews(news);
    }
    /**
     * 新闻分页查询
     * @param pageQuery 分页查询对象
     */
    @GetMapping("/page")
    public ResponseVO queryUserPage(NewPageQuery newPageQuery){
        return newsService.queryNewsPage(newPageQuery);
    }



}
