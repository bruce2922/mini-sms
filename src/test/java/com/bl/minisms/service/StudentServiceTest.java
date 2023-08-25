package com.bl.minisms.service;

import com.bl.minisms.model.Category;
import com.bl.minisms.model.Contact;
import com.bl.minisms.model.Student;
import com.bl.minisms.model.dto.PageData;
import com.bl.minisms.model.enums.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@Transactional
@Rollback
class StudentServiceTest {

    @Autowired
    private StudentService studentService;
    private Student student;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ContactService contactService;

    @BeforeEach
    void setup(){
        assertTrue(studentService != null);

        String name = "Student-test";
        String stuNum = String.valueOf(System.currentTimeMillis());
        LocalDate birthDate = LocalDate.parse("1982-09-22");
        String address = "North Shore, Auckland, NZ";
        Category category = categoryService.getAll().get(0);
        Contact contact = contactService.getAll().get(0);
        List<Contact> contactList = new ArrayList();
        contactList.add(contact);
        student = new Student(name, stuNum, birthDate, Gender.MALE, address,category, contactList);
    }

    @Test
    void addTest() {
        assertEquals(1,add());
        assertTrue(student.getId() != null);
    }

    @Test
    void getByIdTest() {
        add();
        assertEquals(student.getStudentNumber(), getById().getStudentNumber());
        assertEquals(Gender.MALE, getById().getGender());
    }

    @Test
    void removeTest() {
        add();
        assertEquals(1, studentService.removeById(student.getId()));
    }

    @Test
    void updateTest() {
        add();
        Student newStudent =  new Student();
        newStudent.setId(student.getId());
        newStudent.setName("Ariel");
        newStudent.setGender(Gender.FEMALE);
        newStudent.setCategory(categoryService.getAll().get(1));

        Contact contact = contactService.getAll().get(1);
        List<Contact> contactList = new ArrayList();
        contactList.add(contact);
        newStudent.setContactList(contactList);

        studentService.update(newStudent);
    }

    @Test
    void getAllTest() {
        add();
        assertEquals(studentService.getCount(),studentService.getAll().size());
    }

    @Test
    void getAllByPageTest(){
       PageData pd =  studentService.getAllByPage(1, PageData.DEFAULT_PAGE_SIZE);
       long count = studentService.getCount();
       assertEquals(count,pd.getTotalCount());
       if(count >= PageData.DEFAULT_PAGE_SIZE){
           assertEquals(PageData.DEFAULT_PAGE_SIZE,pd.getDataList().size());
       }
    }

    private int add() {
        return studentService.add(student);
    }

    private Student getById(){
        return studentService.getById(student.getId());
    }

}
