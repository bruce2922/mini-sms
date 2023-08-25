package com.bl.minisms.service;

import java.util.List;

public interface BaseService<T> {

    int add(T t);

    int removeById(Long id);

    int update(T t);

    T getById(Long id);

    List<T> getAll();

    long getCount();
}
