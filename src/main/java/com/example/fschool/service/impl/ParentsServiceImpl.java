package com.example.fschool.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fschool.mapper.ParentsMapper;
import com.example.fschool.model.dto.ParentDTO;
import com.example.fschool.model.dto.ParentLoginDTO;
import com.example.fschool.model.dto.ParentRegisterDTO;
import com.example.fschool.model.po.News;
import com.example.fschool.model.po.Parents;
import com.example.fschool.model.po.Students;
import com.example.fschool.model.query.ParentPageQuery;
import com.example.fschool.model.vo.PageVO;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.IParentsService;
import com.example.fschool.utils.BusinessException;
import com.example.fschool.utils.JWTUtil;
import com.example.fschool.utils.RandomUtils;
import com.example.fschool.utils.ResponseEnum;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentsServiceImpl extends ServiceImpl<ParentsMapper, Parents> implements IParentsService {
    @Autowired
    private ParentsMapper parentsMapper;
    @Override
    public ResponseVO login(ParentLoginDTO parentLoginDTO) {
        List<Parents> parentsList= parentsMapper.selectList(new QueryWrapper<Parents>().eq("account", parentLoginDTO.getAccount()));

        if (parentsList != null && parentsList.size() ==1) {
            Parents parents = parentsList.get(0);//验证通过
            String crypt = Md5Crypt.md5Crypt(parentLoginDTO.getParentPwd().getBytes(), parents.getSecret());//对请求过来的密码进行加密
            if (crypt.equals(parents.getParentPwd())) {
                String token = JWTUtil.geneJsonWebTokenParent(parents);//生成token
                return ResponseVO.ok().data("token",token);
            }else {
                return ResponseVO.setResult(ResponseEnum.USER_PWD_ERROR);//密码错误
            }
        }else {

            return ResponseVO.setResult(ResponseEnum.ACCOUNT_UNREGISTER);//未注册
        }
    }

    @Override
    public ResponseVO register(ParentRegisterDTO parentRegisterDTO) {
//        if(parentRegisterDTO.getParentName()==null){
//            throw new BusinessException(ResponseEnum.REGISTER_FAIL);
//        }
        Parents parents = new Parents();//new用户一个对象
        BeanUtils.copyProperties(parentRegisterDTO, parents);//拷贝值
        parents.setSecret("$1$" + RandomUtils.getRandomString(6));//随机生成一个盐
        String pwd = Md5Crypt.md5Crypt(parentRegisterDTO.getParentPwd().getBytes(), parents.getSecret());//密码+盐 加密处理
        parents.setParentPwd(pwd);//设置密码
        //账号唯一性检查 123456@qq.com
        if (checkUnique(parents.getAccount())) {
            parentsMapper.insert(parents);//保存用户信息
            return ResponseVO.ok().message("注册成功");//返回成功
        } else {
            return ResponseVO.setResult(ResponseEnum.USER_REPEAT);//用户已经存在
        }
    }

    /**
     * 家长的更新
     * @param parentDTO
     * @return
     */
    @Override
    public ResponseVO updateByIdYa(ParentDTO parentDTO) {
        Parents parents=new Parents();
        BeanUtils.copyProperties(parentDTO,parents);
        if(checkUpdateUnique(parents.getAccount(),parents.getParentId())){
            parentsMapper.updateById(parents);
            return ResponseVO.ok().message("更新成功");
        }else{
            return ResponseVO.setResult(ResponseEnum.UPDATE_FAILED);
        }
    }
    /**
     * 家长分页查询
     * @param pageQuery
     * @return
     */
    @Override
    public ResponseVO queryParentPage(ParentPageQuery pageQuery) {
        Page<Parents> sort = pageQuery.toMpPageDefaultSortByCreateTimeDesc();
        Page<Parents> page = lambdaQuery().eq(StringUtils.isNotBlank(pageQuery.getAccount()),Parents::getAccount, pageQuery.getAccount())
                .like(StringUtils.isNotBlank(pageQuery.getParentName()),Parents::getParentName, pageQuery.getParentName())
                .page(sort);
        PageVO<Parents> parentsPageVO = new PageVO<>();
        parentsPageVO.of(page);
        return ResponseVO.ok().data("items",parentsPageVO);
    }
    /**
     * 注册
     *
     */
    private boolean checkUnique(String account) {
        QueryWrapper queryWrapper = new QueryWrapper<Parents>().eq("account", account);//创建查询条件
        List<Parents> list = parentsMapper.selectList(queryWrapper); //查找数据库中是否有对应的账号
        return list.size() > 0 ? false : true;//大于零返回false否则返回true
    }
    /**
     * 更新
     * @param account
     * @return
     */
    private boolean checkUpdateUnique(String account,Long parentId) {
        QueryWrapper queryWrapper = new QueryWrapper<Parents>().eq("account", account);//创建查询条件
        List<Parents> list = parentsMapper.selectList(queryWrapper); //查找数据库中是否有对应的账号
        if (list.size()>0){
            if(!list.get(0).getParentId().equals(parentId)){
                return false;
            }else{
                return true;
            }
        }
        return true;
    }
}
