package com.example.fschool.service;

import com.example.fschool.model.po.News;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fschool.model.query.NewPageQuery;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.impl.NewsServiceImpl;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lirui
 * @since 2024-12-08
 */
public interface INewsService extends IService<News> {

    ResponseVO queryNewsPage(NewPageQuery newPageQuery);
}
