package com.bl.minisms.mapper;

import com.bl.minisms.model.Contact;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ContactMapper {

    @Insert("INSERT INTO contact(name, relationship_value, address, email, phone) " +
            "VALUES (#{name},#{relationshipValue},#{address},#{email},#{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(Contact contact);

    @Delete("DELETE FROM contact WHERE id = #{id}")
    int deleteById(@Param("id") Long id);

    @Update("UPDATE contact SET name = #{name} WHERE id = #{id}")
    int update(Contact contact);

    @Select("SELECT * FROM contact WHERE id = #{id}")
    Contact selectById(@Param("id") Long id);

    @Select("SELECT * FROM contact")
    List<Contact> selectAll();

    @Select("SELECT COUNT(1) FROM contact")
    long selectCount();
}
