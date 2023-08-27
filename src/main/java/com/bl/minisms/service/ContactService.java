package com.bl.minisms.service;

import com.bl.minisms.model.Contact;

import java.util.List;

public interface ContactService extends BaseService<Contact> {

    long getCountByIds(List ids);

    int addBatch(List<Contact> list);
}
