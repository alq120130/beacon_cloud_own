package com.alq.webmaster.mapper;


import com.alq.webmaster.entity.SmsUser;
import com.alq.webmaster.entity.SmsUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmsUserMapper {

    long countByExample(SmsUserExample example);

    int deleteByExample(SmsUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SmsUser row);

    int insertSelective(SmsUser row);

    List<SmsUser> selectByExample(SmsUserExample example);

    SmsUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") SmsUser row, @Param("example") SmsUserExample example);

    int updateByExample(@Param("row") SmsUser row, @Param("example") SmsUserExample example);

    int updateByPrimaryKeySelective(SmsUser row);

    int updateByPrimaryKey(SmsUser row);
}