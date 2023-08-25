package com.bl.minisms.mapper;


import com.bl.minisms.model.StudentContact;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentContactMapper {


    int insertBatch(List<StudentContact> list);

    @Delete("DELETE FROM student_contact WHERE stu_id = #{stuId}")
    int deleteByStuId(@Param("stuId") Long id);

}
