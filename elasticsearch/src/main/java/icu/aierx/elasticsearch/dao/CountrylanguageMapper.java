package icu.aierx.elasticsearch.dao;

import icu.aierx.elasticsearch.model.po.Countrylanguage;
import org.apache.ibatis.annotations.Param;

/**
 * @author leiwenyong
 * @since 2022/3/17
 */
public interface CountrylanguageMapper {
    int deleteByPrimaryKey(@Param("countrycode") String countrycode, @Param("language") String language);

    int insert(Countrylanguage record);

    int insertSelective(Countrylanguage record);

    Countrylanguage selectByPrimaryKey(@Param("countrycode") String countrycode, @Param("language") String language);

    int updateByPrimaryKeySelective(Countrylanguage record);

    int updateByPrimaryKey(Countrylanguage record);
}