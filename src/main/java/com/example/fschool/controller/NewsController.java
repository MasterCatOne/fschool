package com.example.fschool.controller;

import com.example.fschool.model.po.News;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.impl.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
