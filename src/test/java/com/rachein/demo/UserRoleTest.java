package com.rachein.demo;

import com.rachein.demo.entity.db.Permission;
import com.rachein.demo.entity.db.Role;
import com.rachein.demo.entity.db.User;
import com.rachein.demo.entity.dto.UserDTO;
import com.rachein.demo.entity.dto.UserRoleDTO;
import com.rachein.demo.Rachein.mapper.PermissionMapper;
import com.rachein.demo.Rachein.mapper.RoleMapper;
import com.rachein.demo.Rachein.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/11 9:42
 */
@SpringBootTest
public class UserRoleTest {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    PermissionMapper permissionMapper;



    @Test
    void t1() {
        UserDTO userDTO = new UserDTO();
        UserRoleDTO userRoleDTO = new UserRoleDTO();
        User user = userMapper.selectById(1);
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

        System.out.println(userDTO);
    }

    @Test
    void t2() {
        UserDTO userDTO = new UserDTO();
        UserRoleDTO userRoleDTO = new UserRoleDTO();
        User user = userMapper.selectById(1);
        BeanUtils.copyProperties(user, userDTO);
        Role role = roleMapper.selectById(user.getRoleId());
        BeanUtils.copyProperties(role, userRoleDTO);

        userDTO.setUserRole(userRoleDTO);
        System.out.println(userDTO.getUserRole().getName());
    }

}
