package com.rachein.demo.entity.db;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/11 9:37
 */
@TableName("role")
@Data
public class Role {

    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String description;
    @TableField("permission_id")
    private String permissionId;

}
