package com.aierx.config.entity;

import com.aierx.config.entity.Properties;

/**
 * @author leiwenyong
 * @since 2022/3/13
 */
public interface PropertiesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Properties record);

    int insertSelective(Properties record);

    Properties selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Properties record);

    int updateByPrimaryKey(Properties record);
}