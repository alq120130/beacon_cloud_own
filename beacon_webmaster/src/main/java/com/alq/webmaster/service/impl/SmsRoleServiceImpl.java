package com.alq.webmaster.service.impl;


import com.alq.webmaster.mapper.SmsRoleMapper;
import com.alq.webmaster.service.SmsRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @author zjw
 * @description
 */
@Service
public class SmsRoleServiceImpl implements SmsRoleService {

    @Resource
    private SmsRoleMapper roleMapper;

    @Override
    public Set<String> getRoleName(Integer userId) {
        Set<String> roleNameSet = roleMapper.findRoleNameByUserId(userId);
        return roleNameSet;
    }
}
