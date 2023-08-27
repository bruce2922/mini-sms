package com.bl.minisms.service;

import com.bl.minisms.model.Contact;
import com.bl.minisms.model.enums.Relationship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@SpringBootTest
@Transactional
@Rollback
class ContactServiceTest {

    @Autowired
    private ContactService contactService;
    private Contact contact;

    @BeforeEach
    void setup(){
        assertTrue(contactService != null);

        String name = "Bruce-contact-test";
        String address = "North Shore, Auckland, NZ";
        String email = "bruceliu@gmail.com";
        String phone = "0204567890";

        contact = new Contact(name, Relationship.BROTHER, address, email, phone);
    }

    @Test
    void addTest() {
        assertEquals(1,add());
        assertTrue(contact.getId() != null);
    }

    @Test
    void getByIdTest() {
        add();
        assertNotNull(contactService.getById(contact.getId()).getRelationship());
        assertEquals(contact.getRelationship(),contactService.getById(contact.getId()).getRelationship());
    }

    @Test
    void getAllTest() {
        assertEquals(contactService.getCount(),contactService.getAll().size());
    }

    @Test
    void getCountByIdsTest() {
        add();
        List idList = new ArrayList();
        idList.add(contact.getId());
        add();
        idList.add(contact.getId());
        assertEquals(2,contactService.getCountByIds(idList));
    }

    @Test
    void addBatchTest() {
        List list = new ArrayList();
        Contact contact1 = new Contact("Ariel", Relationship.MOTHER, "CBD, Auckland, NZ", "ariel@gmail.com", "021 4567 8901");
        Contact contact2 = new Contact("Bruce", Relationship.FATHER, "North Shore, Auckland, NZ", "bruce@gmail.com", "022 4567 8902");

        list.add(contact1);
        list.add(contact2);

        assertEquals(list.size(),contactService.addBatch(list));
    }

    private int add() {
        return contactService.add(contact);
    }

}
