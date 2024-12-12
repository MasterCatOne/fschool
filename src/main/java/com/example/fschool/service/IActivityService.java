package com.example.fschool.service;

import com.example.fschool.model.po.Activitys;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fschool.model.vo.ResponseVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author novel
 * @since 2024-12-12
 */
public interface IActivityService extends IService<Activitys> {

    ResponseVO saveActivity(Activitys activitys);

    ResponseVO updateActivity(Activitys activitys);
}
