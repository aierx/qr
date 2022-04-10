package com.aierx.config.environment;

import org.apache.ibatis.annotations.Param;

import com.aierx.config.entity.Properties;

import java.util.List;

public interface PropertiesDao {
    List<PropertiesEntity> findAll();

    int deleteByPrimaryKey(Integer id);

    int insert(Properties record);

    int insertSelective(Properties record);

    Properties selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Properties record);

    int updateByPrimaryKey(Properties record);

    List<Properties> findAllById(@Param("id")Integer id);

}
