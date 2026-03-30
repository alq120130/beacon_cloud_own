package com.alq.api.controller;

import com.alq.api.filter.CheckFilterContext;
import com.alq.common.model.StandardSubmit;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: alq
 * @Date: 2026/3/30 - 03 - 30 - 12:11
 * @Description: com.alq.api.controller
 * @version: 1.0
 */
@Controller
public class SmsControllerTest {
    @Autowired
    private CheckFilterContext checkFilterContext;
    @GetMapping("/api/check")
    public void check(){
        checkFilterContext.check(new StandardSubmit());
    }

}
