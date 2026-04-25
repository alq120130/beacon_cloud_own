package com.alq.webmaster.service.impl;


import com.alq.webmaster.entity.SmsUser;
import com.alq.webmaster.entity.SmsUserExample;
import com.alq.webmaster.mapper.SmsUserMapper;
import com.alq.webmaster.service.SmsUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author alq
 * @description
 */
@Service
public class SmsUserServiceImpl implements SmsUserService {

    @Resource
    private SmsUserMapper userMapper;

    @Override
    public SmsUser findByUsername(String username) {
        //1、封装查询条件
        SmsUserExample example = new SmsUserExample();
        SmsUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        //2、基于userMapper查询
        List<SmsUser> list = userMapper.selectByExample(example);
        //3、返回
        return list != null ? list.get(0) : null;
    }
}
