package com.alq.test.mapper;

import com.alq.test.entity.MobileArea;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author alq
 * @description
 */
public interface MobileAreaMapper {

    @Select("select mobile_number,mobile_area,mobile_type from mobile_area")
    List<MobileArea> findAll();

}
