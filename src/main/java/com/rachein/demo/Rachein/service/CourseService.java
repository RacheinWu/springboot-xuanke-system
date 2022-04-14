package com.rachein.demo.Rachein.service;

import com.rachein.demo.entity.db.Course;
import com.rachein.demo.entity.ro.CourseRO;
import com.rachein.demo.entity.vo.UserInfoVo;

import java.util.List;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/11 17:54
 */
public interface CourseService {

    /**
     * 获取课程列表
     */
    List<Course> get();

    /**
     * 选课
     */
    void entry(Integer courseId);

    List<Course> getMyCourse();

    void quit(Integer courseId);

    /**
     * [老师] 添加课程
     */
    void add(CourseRO courseRO);

    /**
     * 获取选择这门课的学生名单
     */
    List<UserInfoVo> getStudents(Integer courseId);

    void update(CourseRO courseRO, Integer courseId);
}
