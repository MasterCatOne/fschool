package com.example.fschool.service;

import com.example.fschool.model.dto.ParentLoginDTO;
import com.example.fschool.model.dto.ParentRegisterDTO;
import com.example.fschool.model.po.Parents;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.fschool.model.vo.ResponseVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lirui
 * @since 2024-12-08
 */
public interface IParentsService extends IService<Parents> {

    ResponseVO login(ParentLoginDTO parentLoginDTO);

    ResponseVO register(ParentRegisterDTO parentRegisterDTO);
}
