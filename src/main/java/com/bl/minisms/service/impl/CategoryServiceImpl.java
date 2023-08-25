package com.bl.minisms.service.impl;

import com.bl.minisms.mapper.CategoryMapper;
import com.bl.minisms.model.Category;
import com.bl.minisms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public int add(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public int removeById(Long id) {
        return categoryMapper.deleteById(id);
    }

    @Override
    public int update(Category category) {
        return categoryMapper.update(category);
    }

    @Override
    public Category getById(Long id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public List<Category> getAll() {
        return categoryMapper.selectAll();
    }

    @Override
    public long getCount() {
        return categoryMapper.selectCount();
    }
}
