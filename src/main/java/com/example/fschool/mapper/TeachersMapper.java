package com.example.fschool.mapper;

import com.example.fschool.model.po.Teachers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lirui
 * @since 2024-12-08
 */
public interface TeachersMapper extends BaseMapper<Teachers> {
    @Select("select * from teachers where teacher_id=#{teacherId}")
    @Results(value = {
            @Result(property="teacherId", column="teacher_id"),
            @Result(property="teacherName", column="teacher_name"),
            @Result(property="teacherAge", column="teacher_age"),
            @Result(property="teacherPwd", column="teacher_pwd"),
            @Result(property="teacherSex", column="teacher_sex"),
            @Result(property="gonghao", column="gonghao"),
            @Result(property="role", column="role"),
            @Result(property="studentsList",javaType = List.class,column = "teacher_id",many = @Many(select = "com.example.fschool.mapper.StudentsMapper.getByStudentIdOrderByTeacherId")),
    })

    List<Teachers> getTeacherList(Long teacherId);

}
