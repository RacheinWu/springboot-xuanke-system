package com.rachein.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class DemoApplicationTests {

    @Test
    void contextLoads() {

        log.error("ceshiceshi2");
        log.info("info");
        log.debug("debug");
        log.warn("warm");
    }

}
