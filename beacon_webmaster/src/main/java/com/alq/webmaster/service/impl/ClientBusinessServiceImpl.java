package com.alq.webmaster.service.impl;


import com.alq.webmaster.entity.ClientBusiness;
import com.alq.webmaster.entity.ClientBusinessExample;
import com.alq.webmaster.mapper.ClientBusinessMapper;
import com.alq.webmaster.service.ClientBusinessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zjw
 * @description
 */
@Service
public class ClientBusinessServiceImpl implements ClientBusinessService {

    @Resource
    private ClientBusinessMapper clientBusinessMapper;

    @Override
    public List<ClientBusiness> findAll() {
        List<ClientBusiness> list = clientBusinessMapper.selectByExample(null);
        return list;
    }

    @Override
    public List<ClientBusiness> findByUserId(Integer userId) {
        ClientBusinessExample example = new ClientBusinessExample();
        example.createCriteria().andExtend1EqualTo(userId + "");
        List<ClientBusiness> list = clientBusinessMapper.selectByExample(example);
        return list;
    }

    @Override
    public ClientBusiness findById(Long id) {
        return clientBusinessMapper.selectByPrimaryKey(id);
    }
}
