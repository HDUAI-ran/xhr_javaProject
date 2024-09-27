package com.example.demo;

import com.example.demo.common.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void getBC() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = "123456";
        String encode = bCryptPasswordEncoder.encode(password);
        System.out.println(encode);//$2a$10$8YLZUgEpYs9/CR.c81jcZ.TDWJHPSmfmA2EBmBX7YvjMEPtGWBiVK
    }

}
