package com.alq.api.filter;

import com.alq.common.model.StandardSubmit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Auther: alq
 * @Date: 2026/3/30 - 03 - 30 - 12:07
 * @Description: com.alq.api.filter
 * @version: 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CheckFilterContextTest {
    @Autowired
    private CheckFilterContext checkFilterContext;
    @Test
    public void check() {
        checkFilterContext.check(new StandardSubmit());
    }
}