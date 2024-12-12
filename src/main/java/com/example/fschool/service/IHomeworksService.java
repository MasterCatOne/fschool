package com.example.fschool.service;

import com.example.fschool.model.po.Homeworks;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fschool.model.query.HomeworkPageQuery;
import com.example.fschool.model.vo.ResponseVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lirui
 * @since 2024-12-08
 */
public interface IHomeworksService extends IService<Homeworks> {

    ResponseVO queryHomeworkPage(HomeworkPageQuery homeworkPageQuery);

    ResponseVO saveHomework(Homeworks homeworks);

    ResponseVO updateHomework(Homeworks homeworks);
}
