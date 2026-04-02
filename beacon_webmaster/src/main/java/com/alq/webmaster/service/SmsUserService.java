package com.alq.webmaster.service;


import com.alq.webmaster.entity.SmsUser;

/**
 * 用户信息的Service
 * @author zjw
 * @description
 */
public interface SmsUserService {


    /**
     * 根据用户名查询用户信息
     * @param username  用户名
     * @return
     */
    SmsUser findByUsername(String username);

}
