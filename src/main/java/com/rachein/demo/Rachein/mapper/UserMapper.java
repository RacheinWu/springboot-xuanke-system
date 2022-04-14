package com.rachein.demo.Rachein.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.rachein.demo.entity.db.User;
import com.rachein.demo.entity.vo.UserInfoVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/11 9:39
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select nickname, id, department from user where id = ${uid}")
    UserInfoVo getUserInfoVO(@Param("uid") Integer uid);

}
