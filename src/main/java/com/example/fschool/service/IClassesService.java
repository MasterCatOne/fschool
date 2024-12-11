package com.example.fschool.service;

import com.example.fschool.model.po.Classes;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fschool.model.query.ClassPageQuery;
import com.example.fschool.model.vo.ResponseVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lirui
 * @since 2024-12-08
 */
public interface IClassesService extends IService<Classes> {

    ResponseVO queryHomeworkPage(ClassPageQuery classPageQuery);
}
