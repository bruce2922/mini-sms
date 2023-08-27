package com.bl.minisms.mapper;


import org.apache.ibatis.annotations.Update;

public interface DataInitialMapper {

    @Update("SET FOREIGN_KEY_CHECKS=#{value}")
    void setForeignKeyChecks(int value);

    @Update("TRUNCATE TABLE ${tableName}")
    void truncateTable(String tableName);
}
