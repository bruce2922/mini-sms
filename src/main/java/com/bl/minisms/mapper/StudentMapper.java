package com.bl.minisms.mapper;

import com.bl.minisms.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {

    @Insert("INSERT INTO student(name, student_number, birth_date, gender_value, starting_date, leaving_date, address, category_id) " +
            "VALUES (#{name},#{studentNumber},#{birthDate},#{genderValue},#{startingDate},#{leavingDate},#{address}, #{category.id})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insert(Student student);

    @Delete("DELETE FROM student WHERE id = #{id}")
    int deleteById(@Param("id") Long id);


    Student selectById(Long id);

    List<Student> selectAll();

    int update(Student student);

    List<Student> selectAllByPage(int startIndex, int dataSize);

    @Select("SELECT COUNT(1) FROM student")
    long selectCount();
}
