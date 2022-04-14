package com.rachein.demo.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description 学生&课程关系表
 * @date 2022/4/11 18:17
 */
@Data
@TableName("student_course")
public class CourseStudentDB {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("student_id")
    private Integer studentId;

    @TableField("course_id")
    private Integer courseId;

}
