package com.example.fschool.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fschool.mapper.HomeworksMapper;
import com.example.fschool.model.po.Homeworks;
import com.example.fschool.model.query.HomeworkPageQuery;
import com.example.fschool.model.vo.PageVO;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.IHomeworksService;
import com.example.fschool.utils.ResponseEnum;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworksServiceImpl extends ServiceImpl<HomeworksMapper, Homeworks> implements IHomeworksService {
    @Autowired
    private HomeworksMapper homeworksMapper;
    @Override
    public ResponseVO queryHomeworkPage(HomeworkPageQuery homeworkPageQuery) {
        Page<Homeworks> sort = homeworkPageQuery.toMpPageDefaultSortByCreateTimeDesc();
        Page<Homeworks> page = lambdaQuery().eq(StringUtils.isNotBlank(homeworkPageQuery.getHomeworkTitle()),Homeworks::getHomeworkTitle, homeworkPageQuery.getHomeworkTitle())
                .like(ObjectUtils.isNotEmpty(homeworkPageQuery.getTeacherId()),Homeworks::getHomeworkId, homeworkPageQuery.getTeacherId())
                .page(sort);
        PageVO<Homeworks> teachersPageVO = new PageVO<>();
        teachersPageVO.of(page);
        return ResponseVO.ok().data("items",teachersPageVO);
    }

    @Override
    public ResponseVO saveHomework(Homeworks homeworks) {
        if(checkUnique(homeworks.getHomeworkTitle())){
            homeworksMapper.insert(homeworks);
            return ResponseVO.ok().message("创建作业成功");
        }else{

            return ResponseVO.setResult(ResponseEnum.HOMEWORK_REPEAT);
        }
    }

    @Override
    public ResponseVO updateHomework(Homeworks homeworks) {
        if(checkUpdateUnique(homeworks.getHomeworkTitle(),homeworks.getHomeworkId())){
            homeworksMapper.updateById(homeworks);
            return ResponseVO.ok().message("修改作业成功");
        }else{
            return ResponseVO.setResult(ResponseEnum.UPDATE_HOMEWORK_FAILED);
        }
    }

    private boolean checkUpdateUnique(String homeworkTitle, Long homeworkId) {
        QueryWrapper queryWrapper = new QueryWrapper<Homeworks>().eq("homework_title", homeworkTitle);//创建查询条件
        List<Homeworks> list = homeworksMapper.selectList(queryWrapper); //查找数据库中是否有对应的账号
        if (list.size()>0){
            if(!list.get(0).getHomeworkId().equals(homeworkId)){
                return false;
            }else{
                return true;
            }
        }
        return true;
    }

    /**
     * 注册
     * @param account
     * @return
     */
    private boolean checkUnique(String homeworkTitle) {
        QueryWrapper queryWrapper = new QueryWrapper<Homeworks>().eq("homework_title", homeworkTitle);//创建查询条件
        List<Homeworks> list = homeworksMapper.selectList(queryWrapper); //查找数据库中是否有对应的账号
        return list.size() > 0 ? false : true;//大于零返回false否则返回true
    }
}
