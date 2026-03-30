package com.alq.test.mapper;

import com.alq.test.entity.ClientBusiness;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author alq
 * @description
 */
public interface ClientBusinessMapper {

    @Select("select * from client_business where is_delete = 0")
    List<ClientBusiness> findAll();

    @Select("select * from client_business where id = #{id}")
    ClientBusiness findById(@Param("id") Long id);

}