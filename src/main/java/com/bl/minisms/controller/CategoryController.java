package com.bl.minisms.controller;

import com.bl.minisms.model.Category;
import com.bl.minisms.model.dto.ResponseData;
import com.bl.minisms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping("/list")
    public ResponseData<List<Category>> getList(){
        List<Category> list = categoryService.getAll();
        return ResponseData.success(list);
    }
}
