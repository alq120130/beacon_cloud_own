package com.alq.test.mapper;

import com.alq.test.entity.ClientBalance;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author alq
 * @description
 */
public interface ClientBalanceMapper {

    @Select("select * from client_balance where is_delete = 0")
    List<ClientBalance> findAll();

    @Select("select * from client_balance where client_id = #{clientId}")
    ClientBalance findByClientId(@Param("clientId")Long clientId);

}