package com.rachein.demo.Rachein.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rachein.demo.entity.db.CourseStudentDB;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/11 18:21
 */
@Mapper
public interface CourseStudentMapper extends BaseMapper<CourseStudentDB> {

    @Select("select count(id) from student_course where course_id = ${cid} and student_id = ${sid}")
    Integer isExitedBySidCid(@Param("sid") Integer sid, @Param("cid") Integer cid);

    @Select("select course_id from student_course where student_id = ${sid}")
    List<Integer> selectListForCID(@Param("sid") Integer sid);

    @Select("select student_id from student_course where course_id = ${cid}")
    List<Integer> selectListForSID(@Param("cid") Integer cid);

}
