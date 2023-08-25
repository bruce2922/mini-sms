package com.bl.minisms.service;

import com.bl.minisms.model.Student;
import com.bl.minisms.model.dto.PageData;

import java.util.List;

public interface StudentService extends BaseService<Student> {
    PageData getAllByPage(int pageIndex, int pageSize);
}
