package com.bl.minisms.service.impl;

import com.bl.minisms.mapper.StudentContactMapper;
import com.bl.minisms.mapper.StudentMapper;
import com.bl.minisms.model.Student;
import com.bl.minisms.model.StudentContact;
import com.bl.minisms.model.dto.PageData;
import com.bl.minisms.service.StudentService;
import com.bl.minisms.service.common.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentContactMapper scMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int add(Student student) {
        student.setStudentNumber(Utils.getStudentNumber());
        int result = studentMapper.insert(student);

        List<StudentContact> stuContList = getStudentContactList(student);
        if(!stuContList.isEmpty()){
            scMapper.insertBatch(stuContList);
        }
        return result;
    }

    @Override
    public int removeById(Long id) {
        return studentMapper.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int update(Student student) {
        int result = studentMapper.update(student);
        scMapper.deleteByStuId(student.getId());
        scMapper.insertBatch(getStudentContactList(student));
        return result;
    }

    @Override
    public Student getById(Long id) {
        return studentMapper.selectById(id);
    }

    @Override
    public List<Student> getAll() {
        return studentMapper.selectAll();
    }

    @Override
    public long getCount() {
        return studentMapper.selectCount();
    }

    @Override
    public PageData getAllByPage(int pageIndex, int pageSize) {
        int startIndex = (pageIndex -1) * pageSize;
        List list =  studentMapper.selectAllByPage(startIndex, pageSize);
        long count = this.getCount();
        return new PageData(list,count, pageIndex,pageSize);
    }

    private List<StudentContact> getStudentContactList(Student student) {
        List<StudentContact> scList = new ArrayList(student.getContactList().size());
        student.getContactList().stream().forEach(c->{
            StudentContact sc = new StudentContact(student.getId(),c.getId());
            scList.add(sc);
        });
        return scList;
    }
}
