package com.alq.test.mapper;

import com.alq.test.entity.ClientChannel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 
 * @description
 */
public interface ClientChannelMapper {

    @Select("select * from client_channel where is_delete = 0")
    List<ClientChannel> findAll();

}
