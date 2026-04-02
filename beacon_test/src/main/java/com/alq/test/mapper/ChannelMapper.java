package com.alq.test.mapper;

import com.alq.test.entity.Channel;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author
 * @description
 */
public interface ChannelMapper {

    @Select("select * from channel where is_delete = 0")
    List<Channel> findAll();

}
