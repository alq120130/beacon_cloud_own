package com.alq.test.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author
 * @description
 */
public interface MobileDirtyWordMapper {

    @Select("select dirtyword from mobile_dirtyword")
    List<String> findDirtyWord();

}
