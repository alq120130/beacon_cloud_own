package com.alq.test.mapper;

import com.alq.test.entity.MobileBlack;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author alq
 * @description
 */
public interface MobileBlackMapper {

    @Select("select black_number,client_id from mobile_black where is_delete = 0")
    List<MobileBlack> findAll();

}
