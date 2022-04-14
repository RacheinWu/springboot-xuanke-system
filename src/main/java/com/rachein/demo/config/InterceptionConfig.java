package com.rachein.demo.config;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description1
 * @date 2022/4/10 22:19
 */
@Configuration
@EnableWebMvc
public class InterceptionConfig implements WebMvcConfigurer {

    @Autowired
    private IgnoreUrlsConfig ignoreUrlsConfig;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new SaRouteInterceptor((req, resp, handler) -> {
//            List<String> urls = ignoreUrlsConfig.getUrls();
//            SaRouter.match("/**", "/user/login", r -> StpUtil.checkLogin());
////            SaRouter.match("/course/add", r-> StpUtil.checkPermission("course:create"));
////            SaRouter.match("/course/delete/{cid}", r-> StpUtil.checkPermission("course:delete"));
////            SaRouter.match("/course/update/{cid}", r-> StpUtil.checkPermission("course:update"));
////            SaRouter.match("/course/all", "/course/{cid}")
////                    .check(r-> StpUtil.checkPermission("course:read"));
////            SaRouter.match("/course/entry/{cid}", r-> StpUtil.checkPermission("course:entry"));
////            SaRouter.match("/user/quit/{cid}", r-> StpUtil.checkPermission("course:quit"));
////            SaRouter.match("/user/checkLogin2", r-> StpUtil .checkPermission("/user/login"));
//        })).addPathPatterns("/**");
        registry.addInterceptor(new SaAnnotationInterceptor()).addPathPatterns("/**");
    }
}
