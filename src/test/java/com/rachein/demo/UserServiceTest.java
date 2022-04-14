package com.rachein.demo;

import com.rachein.demo.Rachein.service.impl.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 计算机系 ITAEM 吴远健
 * @Description
 * @date 2022/4/14 8:29
 */
@SpringBootTest

public class UserServiceTest {

    @Autowired
    private UserService service;

    @Test
    void t1() {
        System.out.println(service.getRight(4));
    }

}
