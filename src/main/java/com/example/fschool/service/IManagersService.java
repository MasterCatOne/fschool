package com.example.fschool.service;

import com.example.fschool.model.dto.ManagerLoginDTO;
import com.example.fschool.model.dto.ManagerRegisterDTO;
import com.example.fschool.model.po.Managers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fschool.model.query.ManagerPageQuery;
import com.example.fschool.model.vo.ResponseVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lirui
 * @since 2024-12-08
 */
public interface IManagersService extends IService<Managers> {

    ResponseVO login(ManagerLoginDTO managerLoginDTO);

    ResponseVO register(ManagerRegisterDTO managerRegisterDTO);

    ResponseVO queryUserPage(ManagerPageQuery managerPageQuery);
}
