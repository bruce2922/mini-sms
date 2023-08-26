package com.bl.minisms.mapper;


import com.bl.minisms.model.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CategoryMapper {

    @Insert("INSERT INTO category(name) VALUES (#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(Category category);

    @Delete("DELETE FROM category WHERE id = #{id}")
    int deleteById(@Param("id") Long id);

    @Update("UPDATE category SET name = #{name} WHERE id = #{id}")
    int update(Category category);

    @Select("SELECT * FROM category WHERE id = #{id}")
    Category selectById(@Param("id") Long id);

    @Select("SELECT * FROM category ORDER BY id ASC")
    List<Category> selectAll();

    @Select("SELECT COUNT(1) FROM category")
    long selectCount();
}
