package com.bl.minisms.service.impl;

import com.bl.minisms.mapper.DataInitialMapper;
import com.bl.minisms.model.Category;
import com.bl.minisms.model.Contact;
import com.bl.minisms.model.Student;
import com.bl.minisms.model.enums.Gender;
import com.bl.minisms.model.enums.Relationship;
import com.bl.minisms.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataInitialServiceImpl implements DataInitialService {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ContactService contactService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private DataInitialMapper dataInitialMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int init() {
     turnOffForeignKeyCheck();
     clearTable("category");
     clearTable("student_contact");
     clearTable("student");
     clearTable("contact");
     turnOnForeignKeyCheck();

     int result = addCategories();
     result += addContacts();
     result += addStudents();

     return result;
    }

    private void turnOnForeignKeyCheck() {
        setForeignKeyChecks(1);
    }

    private void turnOffForeignKeyCheck() {
        setForeignKeyChecks(0);
    }

    @Override
    public void clearTable(String tableName) {
        dataInitialMapper.truncateTable(tableName);
    }

    @Override
    public void setForeignKeyChecks(int value) {
        dataInitialMapper.setForeignKeyChecks(value);
    }

    private int addStudents() {
        List<Category> categories = categoryService.getAll();
        List<Contact> contacts = contactService.getAll();

        List<Student> list = new ArrayList();
        List<Contact> contactList1 = new ArrayList();
        List<Contact> contactList2 = new ArrayList();

        contactList1.add(contacts.get(0));
        contactList2.add(contacts.get(1));
        contactList2.add(contacts.get(2));

        Student student1 = new Student("Apple", String.valueOf(System.currentTimeMillis()), LocalDate.parse("1982-09-22"), Gender.FEMALE,
                "123 Takapuna, Auckland, NZ",categories.get(0), contactList1);
        Student student3 = new Student("Watermelon", String.valueOf(System.currentTimeMillis()), LocalDate.parse("1992-08-11"), Gender.MALE,
                "456 Northcote, Auckland, NZ",categories.get(1), contactList2);
        Student student2 = new Student("Banana", String.valueOf(System.currentTimeMillis()), LocalDate.parse("2002-07-31"), Gender.OTHER,
                "789 Long bay, Auckland, NZ",categories.get(2), contactList2);
        Student student4 = new Student("Strawberry", String.valueOf(System.currentTimeMillis()), LocalDate.parse("2012-06-20"), Gender.FEMALE,
                "201 Milford, Auckland, NZ",categories.get(0), contacts);
        Student student5 = new Student("Orange", String.valueOf(System.currentTimeMillis()), LocalDate.parse("2022-05-02"), Gender.MALE,
                "305 West, Mt Albert, NZ",categories.get(1), contacts);

        list.add(student1);
        list.add(student2);
        list.add(student3);
        list.add(student4);
        list.add(student5);

        return list.stream().mapToInt(s -> studentService.add(s)).sum();
    }

    private int addContacts() {
        List list = new ArrayList();
        Contact contact1 = new Contact("Ariel", Relationship.MOTHER, "CBD, Auckland, NZ", "ariel@gmail.com", "021 4567 8901");
        Contact contact2 = new Contact("Bruce", Relationship.FATHER, "North Shore, Auckland, NZ", "bruce@gmail.com", "022 4567 8902");
        Contact contact3 = new Contact("Cindy", Relationship.SISTER, "Central, Auckland, NZ", "cindy@gmail.com", "023 4567 8903");
        Contact contact4 = new Contact("David", Relationship.BROTHER, "East, Auckland, NZ", "david@gmail.com", "024 4567 8904");
        Contact contact5 = new Contact("Ethan", Relationship.FRIEND, "West, Auckland, NZ", "ethan@gmail.com", "025 4567 8905");

        list.add(contact1);
        list.add(contact2);
        list.add(contact3);
        list.add(contact4);
        list.add(contact5);

        return contactService.addBatch(list);
    }

    private int addCategories(){
        int result = 0;
        for(int i = 1; i<=3; i++){
            String categoryName = "Level " + i;
            Category category = new Category();
            category.setName(categoryName);
             result +=  categoryService.add(category);
        }
        return result;
    }
}
