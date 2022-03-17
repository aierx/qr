package icu.aierx.elasticsearch.dao;

import icu.aierx.elasticsearch.model.po.Country;

/**
 * @author leiwenyong
 * @since 2022/3/17
 */
public interface CountryMapper {
    int deleteByPrimaryKey(String code);

    int insert(Country record);

    int insertSelective(Country record);

    Country selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(Country record);

    int updateByPrimaryKey(Country record);
}