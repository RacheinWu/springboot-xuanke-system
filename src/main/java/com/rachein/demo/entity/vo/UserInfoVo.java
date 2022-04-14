package com.rachein.demo.entity.vo;

import lombok.Data;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/12 22:30
 */
@Data
public class UserInfoVo {

    private Integer id;
    private String nickname;
    private String department;//班级 或者 行政部门

}
