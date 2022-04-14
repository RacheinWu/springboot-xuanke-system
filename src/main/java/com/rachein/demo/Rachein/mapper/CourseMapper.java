package com.rachein.demo.Rachein.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rachein.demo.entity.db.Course;
import com.rachein.demo.entity.vo.CourseVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/11 18:01
 */
@Mapper
public interface CourseMapper extends BaseMapper<Course> {


}
