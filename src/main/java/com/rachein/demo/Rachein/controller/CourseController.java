package com.rachein.demo.Rachein.controller;

import cn.dev33.satoken.annotation.SaCheckPermission;
import cn.dev33.satoken.annotation.SaCheckRole;
import com.rachein.demo.Rachein.service.CourseService;
import com.rachein.demo.entity.db.Course;
import com.rachein.demo.entity.ro.CourseRO;
import com.rachein.demo.entity.vo.UserInfoVo;
import com.rachein.demo.result.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/11 17:38
 */
@Api(tags = "课程模块 -> 学生选课，退课等操作、老师crud操作")
@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @ApiOperation("[Public]获取课程列表")
    @GetMapping("/all")
    @SaCheckPermission("course:read")
    public ResultVo<List<Course>> getCourseList() {
        return ResultVo.success(courseService.get());
    }

    @ApiOperation("[学生] 选课")
    @GetMapping("/entry/{cid}")
    @SaCheckPermission("course:entry")
    public ResultVo<String> entryCourse(@PathVariable("cid") Integer courseId) {
        courseService.entry(courseId);
        return ResultVo.success(null);
    }

    @ApiOperation("[学生] 查看自己选了什么课程")
    @GetMapping("/mine")
    @SaCheckRole("student")
    public ResultVo<List<Course>> getMyCourse() {
        return ResultVo.success(courseService.getMyCourse());
    }

    @ApiOperation("[学生] 退课")
    @GetMapping("/quit/{cid}")
    @SaCheckPermission("course:quit")
    public ResultVo<Object> quit(@PathVariable("cid") Integer courseId) {
        courseService.quit(courseId);
        return ResultVo.success(null);
    }

    @ApiOperation("[老师] 添加课程")
    @PostMapping("/add")
    @SaCheckPermission("course:add")
    public ResultVo<Object> add(@RequestBody CourseRO courseRO) {
        courseService.add(courseRO);
        return ResultVo.success(null);
    }

    @ApiOperation("查看选择这门课的学生")
    @GetMapping("/{cid}/student")
    @SaCheckPermission("course:read")
    public ResultVo<List<UserInfoVo>> getStudent(@PathVariable("cid") Integer courseId) {
        return ResultVo.success(courseService.getStudents(courseId));
    }

    @ApiOperation("[老师] 修改课程信息")
    @PostMapping("/update/{cid}")
    @SaCheckPermission("course:update")
    public ResultVo<Object> update(@RequestBody CourseRO courseRO, @PathVariable("cid") Integer courseId) {
        courseService.update(courseRO, courseId);
        return ResultVo.success(null);
    }

}