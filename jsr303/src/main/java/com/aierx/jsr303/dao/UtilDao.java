package com.aierx.jsr303.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilDao {
    public int getVersionById(@Param("tableName") String tableName,@Param("id") int id);
}
