package com.rachein.demo.Rachein.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rachein.demo.entity.db.Permission;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/11 9:40
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
}
