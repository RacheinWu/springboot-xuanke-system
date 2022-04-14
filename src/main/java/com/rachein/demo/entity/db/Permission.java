package com.rachein.demo.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/11 9:40
 */
@TableName("permission")
@Data
public class Permission {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String description;
}
