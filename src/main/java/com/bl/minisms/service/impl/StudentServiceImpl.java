package com.bl.minisms.service.impl;

import com.bl.minisms.mapper.StudentContactMapper;
import com.bl.minisms.mapper.StudentMapper;
import com.bl.minisms.model.Category;
import com.bl.minisms.model.Contact;
import com.bl.minisms.model.Student;
import com.bl.minisms.model.StudentContact;
import com.bl.minisms.model.dto.PageData;
import com.bl.minisms.model.exceptions.InvalidArgumentException;
import com.bl.minisms.service.CategoryService;
import com.bl.minisms.service.ContactService;
import com.bl.minisms.service.StudentService;
import com.bl.minisms.service.common.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentContactMapper scMapper;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ContactService contactService;

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
    @Transactional(rollbackFor = Exception.class)
    public int removeById(Long id) {
        scMapper.deleteByStuId(id);
        int result = studentMapper.deleteById(id);
        return result;
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

    @Override
    public void verifyCategory(Long id) throws Exception {
        Category category = categoryService.getById(id);
        if(category == null){
            throw new InvalidArgumentException("Invalid Category");
        }
    }

    @Override
    public void verifyContact(List<Contact> list) throws Exception{
        List idList = list.stream().map(Contact::getId).collect(Collectors.toList());
        long count = contactService.getCountByIds(idList);
        if(list.size() != count){
            throw new InvalidArgumentException("Invalid Contact");
        }
    }
}
