package com.rachein.demo.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/11 17:59
 */
@Data
public class Course {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    @TableField("teacher_id")
    private Integer teacherId;
    @TableField("teacher_name")
    private String teacherName;
}
