package com.example.fschool.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fschool.mapper.TeachersMapper;
import com.example.fschool.model.dto.TeacherDTO;
import com.example.fschool.model.dto.TeacherLoginDTO;
import com.example.fschool.model.dto.TeacherRegisterDTO;
import com.example.fschool.model.po.Parents;
import com.example.fschool.model.po.Students;
import com.example.fschool.model.po.Teachers;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.model.vo.TeacherVO;
import com.example.fschool.service.ITeachersService;
import com.example.fschool.utils.BusinessException;
import com.example.fschool.utils.JWTUtil;
import com.example.fschool.utils.RandomUtils;
import com.example.fschool.utils.ResponseEnum;
import org.apache.commons.codec.digest.Md5Crypt;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl extends ServiceImpl<TeachersMapper, Teachers> implements ITeachersService {
    @Autowired
    private TeachersMapper teachersMapper;


    @Override
    public ResponseVO register(TeacherRegisterDTO teacherRegisterDTO) {
//        if(teacherRegisterDTO.getTeacherName()==null){
//            throw new BusinessException(ResponseEnum.REGISTER_FAIL);
//        }
        Teachers teachers = new Teachers();//new用户一个对象
        BeanUtils.copyProperties(teacherRegisterDTO, teachers);//拷贝值
        teachers.setSecret("$1$" + RandomUtils.getRandomString(6));//随机生成一个盐
        String pwd = Md5Crypt.md5Crypt(teacherRegisterDTO.getTeacherPwd().getBytes(), teachers.getSecret());//密码+盐 加密处理
        teachers.setTeacherPwd(pwd);//设置密码

        //账号唯一性检查 123456@qq.com

        if (checkUnique(teachers.getGonghao())) {
            teachersMapper.insert(teachers);//保存用户信息
            return ResponseVO.ok().message("注册成功");//返回成功
        } else {
            return ResponseVO.setResult(ResponseEnum.USER_REPEAT);//用户已经存在
        }
    }

    @Override
    public ResponseVO login(TeacherLoginDTO teacherRegisterDTO) {
        List<Teachers> teachersList = teachersMapper.selectList(new QueryWrapper<Teachers>().eq("gonghao", teacherRegisterDTO.getGonghao()));

        if (teachersList != null && teachersList.size() ==1) {
            Teachers teachers = teachersList.get(0);//验证通过
            String crypt = Md5Crypt.md5Crypt(teacherRegisterDTO.getTeacherPwd().getBytes(), teachers.getSecret());//对请求过来的密码进行加密
            if (crypt.equals(teachers.getTeacherPwd())) {
                String token = JWTUtil.geneJsonWebTokenTeacher(teachers);//生成token
                return ResponseVO.ok().data("token",token);
            }else {
                return ResponseVO.setResult(ResponseEnum.USER_PWD_ERROR);//密码错误
            }
        }else {

            return ResponseVO.setResult(ResponseEnum.ACCOUNT_UNREGISTER);//未注册
        }
    }

    @Override
    public List<Teachers> getTeacherList(Long teacherId) {
        return teachersMapper.getTeacherList(teacherId);
    }

    /**
     * 教师的更新
     * @param teacherDTO
     * @return
     */
    @Override
    public ResponseVO updateByIdYa(TeacherDTO teacherDTO) {
        Teachers teachers=new Teachers();
        BeanUtils.copyProperties(teacherDTO,teachers);
        if(checkUnique(teachers.getGonghao())){
            System.out.println("我是是否舒服舒服撒旦法撒旦法");
            teachersMapper.updateById(teachers);
            return ResponseVO.ok().message("更新成功");
        }else{
            return ResponseVO.setResult(ResponseEnum.UPDATE_FAILED);//用户已经存在
        }

    }


    private boolean checkUnique(String gonghao) {
        QueryWrapper queryWrapper = new QueryWrapper<Teachers>().eq("gonghao", gonghao);//创建查询条件
        List<Teachers> list = teachersMapper.selectList(queryWrapper); //查找数据库中是否有对应的账号
        return list.size() > 0 ? false : true;//大于零返回false否则返回true
    }
}
