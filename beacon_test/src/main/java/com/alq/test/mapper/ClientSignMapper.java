package com.alq.test.mapper;

import com.alq.test.entity.ClientSign;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author alq
 * @description
 */
public interface ClientSignMapper {

    @Select("select * from client_sign where is_delete = 0")
    List<ClientSign> findAll();

    @Select("select * from client_sign where client_id = #{clientId}")
    List<ClientSign> findByClientId(@Param("clientId")Long clientId);

}