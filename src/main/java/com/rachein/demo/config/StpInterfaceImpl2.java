package com.rachein.demo.config;

import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpUtil;
import com.rachein.demo.entity.dto.UserDTO;
import com.rachein.demo.Rachein.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description 返回用的角色码和权限码
 * @date 2022/3/31 21:41
 */

/**
 * 自定义权限验证接口扩展
 */
@Component
public class StpInterfaceImpl2 implements StpInterface {

    @Autowired
    UserService userService;

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String s) {
//        Integer id = (Integer) loginId;
//        UserDTO loginUser = userService.getRight(id);
        UserDTO userInfo =  (UserDTO)StpUtil.getSession().get(StpUtil.getTokenValue());
        return userInfo.getUserRole().getPermissionList();
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        UserDTO userInfo =  (UserDTO)StpUtil.getSession().get(StpUtil.getTokenValue());
        return Collections.singletonList(userInfo.getUserRole().getName());
    }
}
