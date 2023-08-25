package com.bl.minisms.controller;

import com.bl.minisms.model.Contact;
import com.bl.minisms.model.dto.ResponseData;
import com.bl.minisms.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contact")
//@Api(value = "Contact API")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping("/list")
//    @ApiOperation(value = "Get all contact data", httpMethod = "GET")
    public ResponseData<List<Contact>> getList(){
        List<Contact> list = contactService.getAll();
        return ResponseData.success(list);
    }
}
