package com.example.fschool.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fschool.model.dto.ManagerLoginDTO;
import com.example.fschool.model.dto.ManagerRegisterDTO;
import com.example.fschool.model.po.Managers;
import com.example.fschool.mapper.ManagersMapper;
import com.example.fschool.model.po.News;
import com.example.fschool.model.po.Students;
import com.example.fschool.model.po.Teachers;
import com.example.fschool.model.query.ManagerPageQuery;
import com.example.fschool.model.vo.PageVO;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.IManagersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fschool.utils.BusinessException;
import com.example.fschool.utils.JWTUtil;
import com.example.fschool.utils.RandomUtils;
import com.example.fschool.utils.ResponseEnum;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author author
 * @since 2024-12-08
 */
@Service
public class ManagersServiceImpl extends ServiceImpl<ManagersMapper, Managers> implements IManagersService {
    @Autowired
    private ManagersMapper managersMapper;
    @Override
    public ResponseVO login(ManagerLoginDTO managerLoginDTO) {
        List<Managers> managersList = managersMapper.selectList(new QueryWrapper<Managers>().eq("account", managerLoginDTO.getAccount()));

        if (managersList != null && managersList.size() ==1) {
            Managers managers = managersList.get(0);//验证通过
            String crypt = Md5Crypt.md5Crypt(managerLoginDTO.getManagerPwd().getBytes(), managers.getSecret());//对请求过来的密码进行加密
            if (crypt.equals(managers.getManagerPwd())) {
                String token = JWTUtil.geneJsonWebTokenManager(managers);//生成token
                return ResponseVO.ok().data("token",token);
            }else {
                return ResponseVO.setResult(ResponseEnum.USER_PWD_ERROR);//密码错误
            }
        }else {

            return ResponseVO.setResult(ResponseEnum.ACCOUNT_UNREGISTER);//未注册
        }

    }

    @Override
    public ResponseVO register(ManagerRegisterDTO managerRegisterDTO) {
          if(managerRegisterDTO.getManagerName()==null){
            throw new BusinessException(ResponseEnum.REGISTER_FAIL);
        }
        Managers managers = new Managers();//new用户一个对象
        BeanUtils.copyProperties(managerRegisterDTO, managers);//拷贝值
        managers.setSecret("$1$" + RandomUtils.getRandomString(6));//随机生成一个盐
        String pwd = Md5Crypt.md5Crypt(managerRegisterDTO.getManagerPwd().getBytes(), managers.getSecret());//密码+盐 加密处理
        managers.setManagerPwd(pwd);//设置密码

        //账号唯一性检查 123456@qq.com

        if (checkUnique(managers.getAccount())) {
            managersMapper.insert(managers);//保存用户信息
            return ResponseVO.ok().message("注册成功");//返回成功
        } else {
            return ResponseVO.setResult(ResponseEnum.USER_REPEAT);//用户已经存在
        }
    }

    @Override
    public ResponseVO queryUserPage(ManagerPageQuery managerPageQuery) {
        Page<Managers> sort = managerPageQuery.toMpPageDefaultSortByCreateTimeDesc();
        Page<Managers> page = lambdaQuery().eq(StringUtils.isNotBlank(managerPageQuery.getManagerName()),Managers::getManagerName, managerPageQuery.getManagerName())
                .like(StringUtils.isNotBlank(managerPageQuery.getAccount()),Managers::getAccount, managerPageQuery.getAccount())
                .page(sort);
        PageVO<Managers> managersPageVO = new PageVO<>();
        managersPageVO.of(page);
        return ResponseVO.ok().data("items",managersPageVO);
    }

    private boolean checkUnique(String account) {
        QueryWrapper queryWrapper = new QueryWrapper<Managers>().eq("account", account);//创建查询条件
        List<Managers> list = managersMapper.selectList(queryWrapper); //查找数据库中是否有对应的账号
        return list.size() > 0 ? false : true;//大于零返回false否则返回true
    }
}
