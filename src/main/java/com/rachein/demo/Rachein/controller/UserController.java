package com.rachein.demo.Rachein.controller;

import cn.dev33.satoken.annotation.SaCheckLogin;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import com.rachein.demo.entity.dto.UserDTO;
import com.rachein.demo.result.ResultVo;
import com.rachein.demo.entity.ro.LoginRO;
import com.rachein.demo.Rachein.service.impl.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/10 22:08
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户模块")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation("登录")
    @PostMapping("/login")
    public ResultVo<SaTokenInfo> login2(@RequestBody LoginRO loginRO) {
        return ResultVo.success(userService.login(loginRO));
    }

    @ApiOperation("检查是否登录")
    @GetMapping("/checkLogin")
    @SaCheckLogin
    public boolean isLogin2() {
        return StpUtil.isLogin();
    }

    @ApiOperation("获取用户信息")
    @GetMapping("/info")
    @SaCheckLogin
    public ResultVo<UserDTO> info() {
        int id = StpUtil.getLoginIdAsInt();
        return ResultVo.success(userService.getInfo(id));
    }

    @ApiOperation("退出")
    @GetMapping("/quit")
    @SaCheckLogin
    public ResultVo<Object> quit() {
        userService.quit();
        return ResultVo.success(null);
    }
}
