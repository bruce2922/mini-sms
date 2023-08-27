package com.bl.minisms.service.impl;

import com.bl.minisms.mapper.ContactMapper;
import com.bl.minisms.model.Contact;
import com.bl.minisms.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper contactMapper;

    @Override
    public int add(Contact contact) {
        return contactMapper.insert(contact);
    }

    @Override
    public int removeById(Long id) {
        return contactMapper.deleteById(id);
    }

    @Override
    public int update(Contact contact) {
        return contactMapper.update(contact);
    }

    @Override
    public Contact getById(Long id) {
        return contactMapper.selectById(id);
    }

    @Override
    public List<Contact> getAll() {
        return contactMapper.selectAll();
    }

    @Override
    public long getCount() {
        return contactMapper.selectCount();
    }

    @Override
    public long getCountByIds(List ids) {
        return contactMapper.selectCountByIds(ids);
    }

    @Override
    public int addBatch(List<Contact> list) {
        return contactMapper.insertBatch(list);
    }
}
