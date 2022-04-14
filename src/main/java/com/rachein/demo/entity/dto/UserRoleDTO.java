package com.rachein.demo.entity.dto;

import lombok.Data;

import java.util.List;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/11 9:23
 */
@Data
public class UserRoleDTO {

    private Integer id;
    private String name;
    private List<String> permissionList;

}
