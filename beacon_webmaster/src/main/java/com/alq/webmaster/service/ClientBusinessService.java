package com.alq.webmaster.service;


import com.alq.webmaster.entity.ClientBusiness;

import java.util.List;

/**
 * @author alq
 * @description
 */
public interface ClientBusinessService {
    /**
     * 查询全部客户信息
     * @return
     */
    List<ClientBusiness> findAll();

    /**
     * 根据用户id查询客户信息
     * @param userId
     * @return
     */
    List<ClientBusiness> findByUserId(Integer userId);

    /**
     * 根据客户id查询客户信息
     * @param id
     * @return
     */
    ClientBusiness findById(Long id);
}
