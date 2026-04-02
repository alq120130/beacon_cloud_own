package com.alq.webmaster.service;

import com.alq.webmaster.entity.SmsUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsUserServiceTest {

    @Autowired
    private SmsUserService smsUserService;

    @Test
    public void findByUsername() {
        SmsUser smsUser = smsUserService.findByUsername("admin");
        System.out.println(smsUser);
    }
}