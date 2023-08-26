package com.bl.minisms.service;

import com.bl.minisms.model.Contact;
import com.bl.minisms.model.Student;
import com.bl.minisms.model.dto.PageData;

import java.util.List;

public interface StudentService extends BaseService<Student> {
    PageData getAllByPage(int pageIndex, int pageSize);

    void verifyCategory(Long id) throws Exception;

    void verifyContact(List<Contact> list) throws Exception;
}
