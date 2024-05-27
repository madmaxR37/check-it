package com.example.checkit.controllers;

import com.example.checkit.dto.CategoryDto;
import com.example.checkit.handler.ResponseHandler;
import com.example.checkit.service.serviceImplementation.CategoryServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto categoryDtoEntity = categoryServiceImp.create(categoryDto);
        return ResponseHandler.generateResponseData("Category created successfully", HttpStatus.CREATED,categoryDtoEntity);
    }
}
