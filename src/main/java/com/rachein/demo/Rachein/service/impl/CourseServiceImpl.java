package com.rachein.demo.Rachein.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rachein.demo.Rachein.mapper.CourseMapper;
import com.rachein.demo.Rachein.mapper.CourseStudentMapper;
import com.rachein.demo.Rachein.mapper.UserMapper;
import com.rachein.demo.Rachein.service.CourseService;
import com.rachein.demo.entity.db.Course;
import com.rachein.demo.entity.db.CourseStudentDB;
import com.rachein.demo.entity.db.User;
import com.rachein.demo.entity.ro.CourseRO;
import com.rachein.demo.entity.vo.UserInfoVo;
import com.rachein.demo.excpetors.GlobalException;
import com.rachein.demo.result.CodeMsg;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/11 17:58
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    CourseStudentMapper CSMapper;

    @Autowired
    UserMapper userMapper;


    @Override
    public List<Course> get() {
        return courseMapper.selectList(null);
    }

    @Override
    public void entry(Integer courseId) {
        //检测是否存在此课程：
        Course course;
        course = courseMapper.selectById(courseId);
        //从token中获取该用户的id
        Integer studentId = StpUtil.getLoginIdAsInt();
        if (Objects.isNull(course)) throw new GlobalException(CodeMsg.COURSE_NOT_EXITED);
        //检查该学生是否已经选过这节课了:
        {
            //PASS
            if (CSMapper.isExitedBySidCid(studentId, courseId) > 0) {
                throw new GlobalException(CodeMsg.COURSE_REPEAT);
            }
        }
        //数据库记录保存:
        CourseStudentDB courseStudentDB = new CourseStudentDB();
        courseStudentDB.setCourseId(courseId);
        courseStudentDB.setStudentId(studentId);
        CSMapper.insert(courseStudentDB);
    }

    @Override
    public List<Course> getMyCourse() {
        //从token中获取用户的id, 如果为空，默认自动报错
        Integer studentId = StpUtil.getLoginIdAsInt();
        List<Integer> coursesIds;
        //从中间表中查询该学生选择的课程id列表:
        coursesIds = CSMapper.selectListForCID(studentId);
        //检测是否选过课:
        if (coursesIds.size() == 0) {
            throw new GlobalException(CodeMsg.EMPTY_COURSE_LIST);
        }
        List<Course> courseList = new ArrayList<>();
        for (Integer coursesId : coursesIds) {
            courseList.add(courseMapper.selectById(coursesId));
        }
        return courseList;
    }

    @Override
    public void quit(Integer courseId) {
        //从token中获取用户的id, 如果为空，默认自动报错
        Integer studentId = StpUtil.getLoginIdAsInt();
        //检查该学生是否已经选过这节课了:
        CourseStudentDB courseStudentDB;
        courseStudentDB = CSMapper.selectOne(new QueryWrapper<CourseStudentDB>()
                .eq("student_id", studentId)
                .eq("course_id", courseId));
        if (Objects.isNull(courseStudentDB))
            throw new GlobalException(CodeMsg.COURSE_NOT_EXITED);
        //从数据库中删除记录：
        CSMapper.deleteById(courseStudentDB.getId());

    }

    @Override
    public void add(CourseRO courseRO) {
        if (Objects.isNull(courseRO)) {
            throw new GlobalException(CodeMsg.BIND_ERROR);
        }
        //检测这个老师是否存在
        Long exit = userMapper.selectCount(new QueryWrapper<User>().eq("id", courseRO.getTeacherId()));
        if (exit == 0)
            throw new GlobalException(CodeMsg.USER_NOT_EXITED);
        Course course = new Course();
        BeanUtils.copyProperties(courseRO, course);
        //保存到数据库中：
         courseMapper.insert(course);
    }

    @Override
    public List<UserInfoVo> getStudents(Integer courseId) {
        //先判断数据库中是否存在这门课：
        Long count = courseMapper.selectCount(new QueryWrapper<Course>().eq("id", courseId));
        if (count == 0)
            throw new GlobalException(CodeMsg.COURSE_NOT_EXITED);
        //判断这门课是否有人选择
        List<Integer> studentsId;
        studentsId = CSMapper.selectListForSID(courseId);
        if (studentsId.size() == 0)
            throw new GlobalException(CodeMsg.EMPTY_STUDENT_LIST_COURSE);
        //根据中间表查询到的结果进行遍历：
        List<UserInfoVo> studentList = new ArrayList<>();
        for (Integer studentId : studentsId) {
            studentList.add(userMapper.getUserInfoVO(studentId));
        }
        return studentList;
    }

    @Override
    public void update(CourseRO courseRO, Integer courseId) {
        if (Objects.isNull(courseRO))
            throw new GlobalException(CodeMsg.BIND_ERROR);
        //检测数据库是否存在这个课程
        Long exited = courseMapper.selectCount(new QueryWrapper<Course>().eq("id", courseId));
        if (exited == 0)
            throw new GlobalException(CodeMsg.COURSE_NOT_EXITED);
        Course newCourse = new Course();
        BeanUtils.copyProperties(courseRO, newCourse);
        newCourse.setId(courseId);
        courseMapper.updateById(newCourse);
    }
}
