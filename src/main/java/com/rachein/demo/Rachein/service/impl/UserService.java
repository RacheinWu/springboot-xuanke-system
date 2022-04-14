package com.rachein.demo.Rachein.service.impl;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.rachein.demo.entity.db.Permission;
import com.rachein.demo.entity.db.Role;
import com.rachein.demo.entity.db.User;
import com.rachein.demo.entity.dto.UserDTO;
import com.rachein.demo.entity.dto.UserRoleDTO;
import com.rachein.demo.excpetors.GlobalException;
import com.rachein.demo.Rachein.mapper.PermissionMapper;
import com.rachein.demo.Rachein.mapper.RoleMapper;
import com.rachein.demo.Rachein.mapper.UserMapper;
import com.rachein.demo.result.CodeMsg;
import com.rachein.demo.entity.ro.LoginRO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/11 13:02
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PermissionMapper permissionMapper;

    /**
     * 包含了 接口权限，角色，以及用户信息(不详细)
     * @param loginId
     * @return
     */
    public UserDTO getRight(Integer loginId) {
        UserDTO userDTO = new UserDTO();
        UserRoleDTO userRoleDTO = new UserRoleDTO();
        User user = userMapper.selectById(loginId);
        BeanUtils.copyProperties(user, userDTO);
        Role role = roleMapper.selectById(user.getRoleId());
        BeanUtils.copyProperties(role, userRoleDTO);


        List<String> permissions = new ArrayList<>();
        List<String> permissionIds = Arrays.asList(role.getPermissionId().split("-"));
        for (String permission_id : permissionIds) {
            Permission permission = permissionMapper.selectById(Integer.parseInt(permission_id));
            permissions.add(permission.getName());
        }
        userRoleDTO.setPermissionList(permissions);
        userDTO.setUserRole(userRoleDTO);
        return userDTO;
    }

    public String getRole(Integer loginId) {
        User user = userMapper.selectById(loginId);
        Role role = roleMapper.selectById(user.getRoleId());
        return role.getName();
    }


    public SaTokenInfo login(LoginRO loginRO) {
        User userDB;
        userDB = userMapper.selectOne(new QueryWrapper<User>().eq("username", loginRO.getUsername()));
        if (Objects.isNull(userDB)) {
            throw new GlobalException(CodeMsg.ACCOUNT_NOT_EXITED);
        }
        if (!userDB.getPassword().equals(loginRO.getPassword())) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        StpUtil.login(userDB.getId());
        return StpUtil.getTokenInfo();
    }

    
    public UserDTO getInfo(int id) {
        UserDTO userDTO = getRight(id);
        //存储到session中进行缓存:
        String tokenValue = StpUtil.getTokenValue();
        StpUtil.getSession().set(tokenValue, userDTO);
        System.out.println(StpUtil.getSession().get(tokenValue));
        return userDTO;
    }

    public void quit() {
        StpUtil.getSession().logout();
        StpUtil.logout();
    }
}
