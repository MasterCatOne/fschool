package com.example.fschool.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.fschool.model.po.Activitys;
import com.example.fschool.mapper.ActivityMapper;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.IActivityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fschool.utils.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author novel
 * @since 2024-12-12
 */
@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activitys> implements IActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    /**
     * 活动的添加
     * @param activitys
     * @return
     */
    @Override
    public ResponseVO saveActivity(Activitys activitys) {
        if(checkAddTitle(activitys.getActivityTitle())){
            activityMapper.insert(activitys);
            return ResponseVO.ok().message("添加活动成功");
        }else{
            return ResponseVO.setResult(ResponseEnum.ADD_ACT_FAILED);
        }

    }

    /**
     * 更改活动
     * @param activitys
     * @return
     */

    @Override
    public ResponseVO updateActivity(Activitys activitys) {
        if(checkActivityTitle(activitys.getActivityTitle(),activitys.getActivityId())){
            activityMapper.updateById(activitys);
            return ResponseVO.ok().message("更改活动成功");
        }else{
            return ResponseVO.setResult(ResponseEnum.UPDATE_ACT_FAILED);
        }
    }

    /**
     * 更新
     * @param activityTitle
     * @return
     */
    private boolean checkActivityTitle(String activityTitle,Long activityId) {
        QueryWrapper queryWrapper = new QueryWrapper<Activitys>().eq("activity_title", activityTitle);
        List<Activitys> list = activityMapper.selectList(queryWrapper);
        if (list.size()>0){
            if(!list.get(0).getActivityId().equals(activityId)){
                return false;
            }else{
                return true;
            }
        }
        return true;
    }

    /**
     * 添加
     * @param activityTitle
     * @return
     */
    private boolean checkAddTitle(String activityTitle) {
        QueryWrapper queryWrapper = new QueryWrapper<Activitys>().eq("activity_title", activityTitle);
        List<Activitys> list = activityMapper.selectList(queryWrapper);
        return list.size() > 0 ? false : true;//大于零返回false否则返回true
    }


}
