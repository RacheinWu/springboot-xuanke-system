package com.rachein.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/13 11:48
 */
@Configuration
public class ResourceConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("D:/IdeaProjects/SA TOKEN DEMO/src/main/resources/static/index.html").addResourceLocations("/aaa");
        registry.addResourceHandler("/files/**").addResourceLocations("file:D:/IdeaProjects/SA TOKEN DEMO/src/main/resources/static/");

    }
}
