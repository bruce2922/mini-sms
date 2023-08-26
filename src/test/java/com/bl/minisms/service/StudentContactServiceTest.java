package com.bl.minisms.service;

import com.bl.minisms.model.Category;
import com.bl.minisms.model.Contact;
import com.bl.minisms.model.Student;
import com.bl.minisms.model.StudentContact;
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
class StudentContactServiceTest {

    @Autowired
    private StudentContactService scService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ContactService contactService;
    @Autowired
    private CategoryService categoryService;
    private Student student;


    @BeforeEach
    void setup(){
        assertTrue(scService != null);

        String name = "Student-test";
        String stuNum = String.valueOf(System.currentTimeMillis());
        LocalDate birthDate = LocalDate.parse("1982-09-22");
        String address = "North Shore, Auckland, NZ";
        Category category = categoryService.getAll().get(0);
        student = new Student(name, stuNum, birthDate, Gender.MALE, address,category, new ArrayList<Contact>());
    }

    @Test
    void addBatchTest() {
        List list = new ArrayList();

        studentService.add(student);
        List<Contact> contact = contactService.getAll();
        contact.stream().forEach( c -> {
            StudentContact sc = new StudentContact(student.getId(),c.getId());
            list.add(sc);
        });

        assertEquals(contact.size(), scService.addBatch(list));
    }

    @Test
    void removeByStuIdTest() {
        addBatchTest();
        assertTrue(scService.deleteByStuId(student.getId()) > 1);
    }

}
