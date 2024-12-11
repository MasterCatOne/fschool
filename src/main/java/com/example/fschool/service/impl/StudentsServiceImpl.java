package com.example.fschool.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.fschool.model.dto.StudentDTO;
import com.example.fschool.model.dto.StudentLoginDTO;
import com.example.fschool.model.dto.StudentRegisterDTO;
import com.example.fschool.model.po.Students;
import com.example.fschool.mapper.StudentsMapper;
import com.example.fschool.model.query.StudentPageQuery;
import com.example.fschool.model.vo.PageVO;
import com.example.fschool.model.vo.ResponseVO;
import com.example.fschool.service.IStudentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.fschool.utils.BusinessException;
import com.example.fschool.utils.JWTUtil;
import com.example.fschool.utils.RandomUtils;
import com.example.fschool.utils.ResponseEnum;
import net.minidev.json.JSONUtil;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang3.ObjectUtils;
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
 * @author lirui
 * @since 2024-12-08
 */
@Service
public class StudentsServiceImpl extends ServiceImpl<StudentsMapper, Students> implements IStudentsService {
    @Autowired
    private StudentsMapper studentsMapper;



    public ResponseVO register(StudentRegisterDTO registerDTO) {
        if(registerDTO.getXuehao()==null){
            throw new BusinessException(ResponseEnum.REGISTER_FAIL);
        }
        Students students = new Students();//new用户一个对象
        BeanUtils.copyProperties(registerDTO, students);//拷贝值
        students.setSecret("$1$" + RandomUtils.getRandomString(6));//随机生成一个盐
        String pwd = Md5Crypt.md5Crypt(registerDTO.getStudentPwd().getBytes(), students.getSecret());//密码+盐 加密处理
        students.setStudentPwd(pwd);//设置密码

        //账号唯一性检查 123456@qq.com

        if (checkUnique(students.getXuehao())) {
            studentsMapper.insert(students);//保存用户信息
            return ResponseVO.ok().message("注册成功");//返回成功
        } else {
            return ResponseVO.setResult(ResponseEnum.USER_REPEAT);//用户已经存在
        }
    }

    @Override
    public ResponseVO login(StudentLoginDTO studentLoginDTO) {
        List<Students> userList = studentsMapper.selectList(new QueryWrapper<Students>().eq("xuehao", studentLoginDTO.getXuehao()));

        if (userList != null && userList.size() ==1) {
            Students students = userList.get(0);//验证通过
            String crypt = Md5Crypt.md5Crypt(studentLoginDTO.getStudentPwd().getBytes(), students.getSecret());//对请求过来的密码进行加密
            if (crypt.equals(students.getStudentPwd())) {
                String token = JWTUtil.geneJsonWebToken(students);//生成token
                return ResponseVO.ok().data("token",token);
            }else {
                return ResponseVO.setResult(ResponseEnum.USER_PWD_ERROR);//密码错误
            }
        }else {

            return ResponseVO.setResult(ResponseEnum.ACCOUNT_UNREGISTER);//未注册
        }
    }

    /**
     * 分页查询用户列表
     * @param pageQuery 查询参数
     * @return 分页信息
     */
    @Override
    public ResponseVO queryUserPage(StudentPageQuery pageQuery) {
        Page<Students> sort = pageQuery.toMpPageDefaultSortByCreateTimeDesc();
        Page<Students> page = lambdaQuery().eq(StringUtils.isNotBlank(pageQuery.getXuehao()),Students::getXuehao, pageQuery.getXuehao())
                .like(StringUtils.isNotBlank(pageQuery.getStudentName()),Students::getStudentName, pageQuery.getStudentName())
                .like(ObjectUtils.isNotEmpty(pageQuery.getClassId()),Students::getClassId, pageQuery.getClassId())
                .page(sort);
        PageVO<Students> userPageVo = new PageVO<>();
        userPageVo.of(page);
        return ResponseVO.ok().data("items",userPageVo);
    }

    /**
     * 学生更新的业务
     * @param studentDTO
     * @return
     */
    @Override
    public ResponseVO updateByidYa(StudentDTO studentDTO) {
        Students students = new Students();
        BeanUtils.copyProperties(studentDTO,students);
        if (checkUnique(students.getXuehao())) {
            students.setSecret("$1$" + RandomUtils.getRandomString(6));//随机生成一个盐
            String pwd = Md5Crypt.md5Crypt(studentDTO.getStudentPwd().getBytes(), students.getSecret());//密码+盐 加密处理
            students.setStudentPwd(pwd);//设置密码
            studentsMapper.updateById(students);//保存用户信息
            return ResponseVO.ok().message("更新成功");//返回成功
        } else {
            return ResponseVO.setResult(ResponseEnum.UPDATE_FAILED);//用户已经存在
        }
    }

    private boolean checkUnique(String xuehao) {
        QueryWrapper queryWrapper = new QueryWrapper<Students>().eq("xuehao", xuehao);//创建查询条件
        List<Students> list = studentsMapper.selectList(queryWrapper); //查找数据库中是否有对应的账号
        return list.size() > 0 ? false : true;//大于零返回false否则返回true
    }
}
