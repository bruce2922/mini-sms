package com.bl.minisms.service;

import com.bl.minisms.model.StudentContact;

import java.util.List;

public interface StudentContactService {

    int addBatch(List<StudentContact> list);

    int deleteByStuId(Long id);
}
