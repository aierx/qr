package icu.aierx.elasticsearch.dao;

import icu.aierx.elasticsearch.model.po.City;

/**
 * @author leiwenyong
 * @since 2022/3/17
 */
public interface CityMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);
}