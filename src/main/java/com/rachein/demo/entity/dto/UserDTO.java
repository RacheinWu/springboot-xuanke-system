package com.rachein.demo.entity.dto;

import lombok.Data;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/11 9:22
 */
@Data
public class UserDTO {

    private Integer id;
    private String username;
    private Integer roleId;
    private UserRoleDTO userRole;

}
