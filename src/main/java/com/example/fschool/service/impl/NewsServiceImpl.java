package com.example.fschool.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fschool.mapper.NewsMapper;
import com.example.fschool.model.po.Managers;
import com.example.fschool.model.po.News;
import com.example.fschool.model.po.Students;
import com.example.fschool.model.query.NewPageQuery;
import com.example.fschool.model.query.StudentPageQuery;
import com.example.fschool.model.vo.PageVO;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.INewsService;
import com.example.fschool.utils.ResponseEnum;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {
    @Autowired
    private NewsMapper newsMapper;

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

    /**
     * 添加新闻
     * @param news
     * @return
     */
    @Override
    public ResponseVO saveNews(News news) {
        if(checkUnique(news.getNewTitle())){
            newsMapper.insert(news);
            return ResponseVO.ok().message("添加新闻成功");
        }else{
            return ResponseVO.setResult(ResponseEnum.ADD_NEW_FAILED);
        }
    }

    @Override
    public ResponseVO updateNews(News news) {
        if(checkUpdateUnique(news.getNewTitle(),news.getNewId())){
            newsMapper.updateById(news);
            return ResponseVO.ok().message("修改新闻成功");
        }else{
            return ResponseVO.setResult(ResponseEnum.UPDATE_NEW_FAILED);

        }
    }

    /**
     * 添加
     * @param account
     * @return
     */
    private boolean checkUnique(String newtitle) {
        QueryWrapper<News> queryWrapper = new QueryWrapper<News>().eq("new_title", newtitle);//创建查询条件
        List<News> list = newsMapper.selectList(queryWrapper); //查找数据库中是否有对应的账号
        return list.size() > 0 ? false : true;//大于零返回false否则返回true
    }
    /**
     * 添加
     * @param account
     * @return
     */
    private boolean checkUpdateUnique(String newtitle,Long newId) {
        QueryWrapper<News> queryWrapper = new QueryWrapper<News>().eq("new_title", newtitle);//创建查询条件
        List<News> list = newsMapper.selectList(queryWrapper); //查找数据库中是否有对应的账号
        if (list.size()>0){
            if(!list.get(0).getNewId().equals(newId)){
                return false;
            }else{
                return true;
            }
        }
        return true;

    }

}
