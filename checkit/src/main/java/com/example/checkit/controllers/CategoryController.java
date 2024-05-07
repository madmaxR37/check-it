package com.example.checkit.controllers;

import com.example.checkit.dto.CategoryDto;
import com.example.checkit.service.serviceImplementation.CategoryServiceImp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("check-it/v1/category")
public class CategoryController {

    private final CategoryServiceImp categoryServiceImp;

    public CategoryController(CategoryServiceImp categoryServiceImp) {
        this.categoryServiceImp = categoryServiceImp;
    }

    @PostMapping("/create")
    public CategoryDto createCategory(@RequestBody CategoryDto categoryDto){
        return categoryServiceImp.create(categoryDto);
    }
}
