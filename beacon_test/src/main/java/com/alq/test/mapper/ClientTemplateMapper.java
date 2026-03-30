package com.alq.test.mapper;

import com.alq.test.entity.ClientTemplate;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author alq
 * @description
 */
public interface ClientTemplateMapper {

    @Select("select * from client_template where is_delete = 0")
    List<ClientTemplate> findAll();

    @Select("select * from client_template where sign_id = #{signId}")
    List<ClientTemplate> findBySignId(@Param("signId") Long signId);

}