package com.rachein.demo.Rachein.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/3/31 21:23
 */
@RestController
@RequestMapping("user2")
@Slf4j
@Api(tags = "用来测试安全框架用的")
public class UserControllerDemo {

    @GetMapping("/login")
    @ApiOperation("登录")
    public String login(String username, String password) {
        if (username.equals("1") && password.equals("2")) {
            StpUtil.login(10001);
            return "login success!";
        }
        return "fail!";
    }

    // 查询登录状态，浏览器访问： http://localhost/user/isLogin
    @RequestMapping("/isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

    @RequestMapping("tokenInfo")
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }


    // 测试注销  ---- http://localhost:8081/acc/logout
    @RequestMapping("/logout")
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }

    @GetMapping("/getToken")
    public void getToken() {

        // 获取当前`StpLogic`的token名称
        System.out.println(StpUtil.getTokenName());

        // 获取当前会话的token值
        System.out.println(StpUtil.getTokenValue());


        // 获取当前会话的token信息参数

        System.out.println(StpUtil.getTokenInfo());

    }

    @GetMapping("/t31")
    public void t31() {
        log.error("ceshiceshi2");
        log.info("info");
        log.debug("debug");
        log.warn("warm");
    }



}
