package com.example.fschool.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fschool.mapper.NewsMapper;
import com.example.fschool.model.po.News;
import com.example.fschool.model.po.Students;
import com.example.fschool.model.query.NewPageQuery;
import com.example.fschool.model.query.StudentPageQuery;
import com.example.fschool.model.vo.PageVO;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.INewsService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {

    /**
     * 分页查询用户列表
     * @param pageQuery 查询参数
     * @return 分页信息
     */
    @Override
    public ResponseVO queryNewsPage(NewPageQuery newPageQuery) {
        Page<News> sort = newPageQuery.toMpPageDefaultSortByCreateTimeDesc();
        Page<News> page = lambdaQuery().eq(StringUtils.isNotBlank(newPageQuery.getNewsName()),News::getNewTitle, newPageQuery.getNewsName())
                .like(StringUtils.isNotBlank(newPageQuery.getTeacherId()),News::getTeacherId, newPageQuery.getTeacherId())
                .page(sort);
        PageVO<News> newsPageVO = new PageVO<>();
        newsPageVO.of(page);
        return ResponseVO.ok().data("items",newsPageVO);
    }


}
