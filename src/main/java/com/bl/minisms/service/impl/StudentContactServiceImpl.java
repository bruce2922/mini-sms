package com.bl.minisms.service.impl;

import com.bl.minisms.mapper.StudentContactMapper;
import com.bl.minisms.model.StudentContact;
import com.bl.minisms.service.StudentContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentContactServiceImpl implements StudentContactService {

    @Autowired
    private StudentContactMapper scMapper;

    @Override
    public int addBatch(List<StudentContact> list) {
        return scMapper.insertBatch(list);
    }

    @Override
    public int deleteByStuId(Long id) {
        return scMapper.deleteByStuId(id);
    }
}
