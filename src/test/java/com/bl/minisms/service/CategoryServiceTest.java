package com.bl.minisms.service;

import com.bl.minisms.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@SpringBootTest
@Transactional
@Rollback
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;
    private Category category;

    @BeforeEach
    void setup(){
        assertTrue(categoryService != null);
        category = new Category();
        category.setName("test" + System.currentTimeMillis());
    }

    @Test
    void addTest() {
        assertEquals(1,add());
        assertTrue(category.getId() != null);
    }

    @Test
    void getTest() {
        add();
        assertEquals(category.getName(),categoryService.getById(category.getId()).getName());
    }

    @Test
    void removeTest() {
        add();
        assertEquals(1, categoryService.removeById(category.getId()));
    }

    @Test
    void updateTest() {
        add();
        category.setName(category.getName()+"X");
        assertEquals(1, categoryService.update(category));
    }

    @Test
    void getAllTest() {
        add();
        assertEquals(categoryService.getCount(),categoryService.getAll().size());
    }

    private int add() {
        return categoryService.add(category);
    }

}
