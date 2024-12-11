package com.example.fschool.mapper;

import com.example.fschool.model.po.Students;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lirui
 * @since 2024-12-08
 */
public interface StudentsMapper extends BaseMapper<Students> {
    @Select("select * from students where teacher_id=#{teacherId}")
    List<Students> getByStudentIdOrderByTeacherId(Long teacherId);

}
